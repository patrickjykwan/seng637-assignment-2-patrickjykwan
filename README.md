

## SENG 637: Dependability and Reliability of Software Systems

# Lab. Report #2: Requirements - Based Test Generation

Group Number: 4 | Digit | Character
:------: | :------:|:----------:
John Van Heurn | #30001886 | john.vanheurn1@ucalgary.ca
Patrick Kwan | #10103093 | pjykwan@ucalgary.ca
 
---

### Introduction

This is the second lab of SENG 638: Dependability and Reliability of Software Systems. This lab is an introduction to automated unit testing with specified requirements for each test unit. The JUnit framework will be utilized to test methods from 2 classes, org.jfree.data.Range and org.jfree.data.DataUtilities, in the JFreeChart framework, and the test results will be displayed.


The lab itself is divided into three sections: familiarization, unit test generation, and test code development. The contents of each section can be seen below:

**Familiarization**

In this section, the student will create a JUnit test project using Eclipse and become familiarized with testing tools such as JUnit and JavaDoc. JUnit is a popular unit testing framework for Java applications, and JavaDoc is a method used by programmers to provide adequate documentation of functions and classes.


**Unit Test Generation**

For unit test generation, the JavaDoc for specific methods in the org.jfree.data.Range and org.jfree.data.DataUtilities classes will be used to develop unit test suites. Such test suites will be created using black-box test-case design techniques such as equivalence classes and boundary value analysis.


**Test Code Development**

Here, the test suites generated in the previous section will be used to generate JUnit scripts to evaluate the system under test. For some tests, a mock object will be generated that mimics a real object that would be generated within the application. 

The following report details the group's methods and results of the lab:

---

### Detailed Description of Unit Test Strategy

// include the input partitions you have designed

Per creation of unit test suite, the following guidelines, as mentioned in class lecture, were used to ensure that the unit test creation was thorough yet not redundant. The steps followed were directly copied from the Chapter 04: Black-box Testing lecture when discussing Equivalence Class Testing (ECT) and used in the creation of our unit tests:

1. Decide how many independent variables you have.
2. For each, how many distinct partitions (rangeS) for each variable you have.
3. Select number of test cases based on weka, strong, or robustness criteria.
4. Create test cases using acceptable values assigned from each distinct partitions for each variable involved. 
5. Review test cases: remove redundant, add tests for problems received.
6. Repeat above steps until you are satisfied with the test cases.

Five methods were tested from each of the two classes under test: org.jfree.data.Range and org.jfree.data.DataUtilities. The following methods can be seen below:
- org.jfree.data.Range.contains
- org.jfree.data.Range.constrain
- org.jfree.data.Range.equals
- org.jfree.data.Range.intersects
- org.jfree.data.Range.shift

and 
- org.jfree.data.DataUtilities.calculateColumnTotal
- org.jfree.data.DataUtilities.calculateRowTotal
- org.jfree.data.DataUtilities.createNumberArray
- org.jfree.data.DataUtilities.createNumberArray2D
- org.jfree.data.DataUtilities.getCumulativePercentages

To create a test suite, the API for each method was referred to. The following acronyms will be commonly used:

Acronym | Meaning
:-: | -
AUB | Above Upper Bound
UB | Upper Bound 
BUB | Below Upper Bound
NOM | A Nominal Value
ALB | Above Lower Bound
LB | Lower Bound
BLB | Below Lower Bound


Class (org.jfree.data...) | Variables | Input Partitions
--- | :-: | ---
Range.contains | Value | Robust Worst Case Scenario - **AUB, UB, BUB, NOM, ALB, LB, and BLB**
Range.constrain | Value | Robust Worst Case Scenario - **AUB, UB, BUB, NOM, ALB, LB, and BLB**
Range.equals | Upperbound, Lowerbound | (When Referenced to Constant Range Object, R = reference, T = test) - <div><b>(R.upperbound == T.upperbound && R.lowerbound == T.lowerbound),<b><div><div><b>(R.upperbound != T.upperbound && R.lowerbound == T.lowerbound),<b><div><div><b>(R.upperbound == T.upperbound && R.lowerbound != T.lowerbound), <b><div><div><b>and (R.upperbound != T.upperbound && R.lowerbound != T.lowerbound)<b><div>
Range.intersects | Upperbound, Lowerbound | (When Referenced to Constant Range Object, R = reference)  <div>Robust Worst Case Scenario - **AUB, UB, BUB, NOM, ALB, LB, and BLB**<div> where: [NOM has both boundaries inside R], [UB, BUB, ALB, and LB has one boundary inside R], and [AUB and BLB have no boundaries inside R]
Range.shift | Delta | **Negative Delta, Positive Delta, and Delta is Zero**
DataUtilities.calculateColumnTotal | Column | (When Referenced to Constant Value2D Object) <div><b>(Column < 0),<b><div><div><b>(Column >= 0 && Column <= # of Columns)<b><div><div><b>and (Column > # of Columns)<b><div>
DataUtilities.calculateRowTotal | Row | (When Referenced to Constant Value2D Object) <div><b>(Row < 0),<b><div><div><b>(Row >= 0 && Row <= # of Rows)<b><div><div><b>and (Row > # of Rows)<b><div>
DataUtilities.createNumberArray | Data Array | **Empty Array, Array of Size 1, Array of Size n**
DataUtilities.createNumberArray2D | Data 2D Array | **Empty Array, 1x1 Array, Column Array (1xn), Row Array(nx1), nxn Array**
DataUtilities.getCumulativePercentages | Data | **Empty KeyedValues data, KeyedValues 1 data entry, KeyedValues n data entries**

Additional clarification on the exact tests will be shown in the following section.

---

### How the Team Work / Effort was Divided and Managed

// write down the name of the test methods and classes. Organize them based on the source code method they test, identify which tests cover which partitions you have explained in the test strategy section above


The group members both completed the Familiarization section of the lab prior to meeting via Zoom. Together, they created and drafted the test suites for the five methods listed in the previous section of each class: org.jfree.data.Range and org.jfree.data.DataUtilities. With the test suites identified, the group members split the work and simulated the tests using the JUnit framework. Patrick tackled the methods in the org.jfree.data.Range class, and John tackles the methods in the jfree.data.DataUtilities class. The pair met again via Zoom to review eachother's code and methods, and completed the lab report.

The test suites, test code, and result for each method can be seen below:

**org.jfree.data.Range.contains**

Variables: Value
Constant Variables: Range with lowerbound = 0, upperbound = 100

Partition | (Input) Value | (Output) Expected | (Output) Actual
--- | :-: | :-: | :-:
AUB| 101 | False | 
UB| 100 | True | 
BUB| 99 | True |
NOM| 50 | True |
ALB| 1 | True |
LB| 0 | True |
BLB| -1 | False |


Explanation:

Code:


**org.jfree.data.Range.constrain**

Variables: Value
Constant Variables: Range with lowerbound = 0, upperbound = 100

Partition | (Input) Value | (Output) Expected | (Output) Actual
--- | :-: | :-: | :-:
AUB| 101 | 100 | 
UB| 100 | 100 | 
BUB| 99 | 99 |
NOM| 50 | 50 |
ALB| 1 | 1 |
LB| 0 | 0 |
BLB| -1 | 0 |


Explanation:

Code:

**org.jfree.data.Range.equals**

Variables: Lowerbound, Upperbound
Constant Variables: Range with lowerbound = 0, upperbound = 100

Partition | (Input) Lowerbound | (Input) Upperbound | (Output) Expected | (Output) Actual
--- | :-: | :-: | :-: | :-:
R.upperbound == T.upperbound && R.lowerbound == T.lowerbound | 0 | 100 | True
R.upperbound != T.upperbound && R.lowerbound == T.lowerbound | 0 | 101 | False
R.upperbound == T.upperbound && R.lowerbound != T.lowerbound | -1 | 100 | False
R.upperbound != T.upperbound && R.lowerbound != T.lowerbound | -1 | 101 | False


Explanation:

Code:

**org.jfree.data.Range.intersects**

Variables: Lowerbound, Upperbound
Constant Variables: Range with lowerbound = 0, upperbound = 100

Partition | (Input) Lowerbound | (Input) Upperbound | (Output) Expected | (Output) Actual
--- | :-: | :-: | :-: | :-:
AUB| 101 | 151 | False
UB| 100 | 150 | True
BUB| 99 | 149 | True
NOM| 25 | 75 | True
ALB| -49 | 1 | True
LB| -50 | 0 | True
BLB| -51 | -1 | False


Explanation:

Code:

**org.jfree.data.Range.shift**

Variables: Delta
Constant Variables: Range with lowerbound = 0, upperbound = 100

Partition | (Input) Delta | (Output) Expected Lowerbound | (Output) Expected Upperbound | (Output) Actual Lowerbound | (Output) Actual Upperbound
--- | :-: | :-: | :-: | :-: | :-:
Negative Delta | -25 | -25 | 75 
Positive Delta | 25 | 25 | 125
Delta is Zero | 0 | 0 | 100

Explanation:

Code:

**org.jfree.data.DataUtilities.calculateColumnTotal**
**org.jfree.data.DataUtilities.calculateRowTotal**
**org.jfree.data.DataUtilities.createNumberArray**
**org.jfree.data.DataUtilities.createNumberArray2D**
**org.jfree.data.DataUtilities.getCumulativePercentages**

### Difficulties Encountered, Challenges Overcome, And Lessons Learned

### Comment / Feedback for the Lab Itself 

