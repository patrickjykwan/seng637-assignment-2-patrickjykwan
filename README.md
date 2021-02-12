

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

Table 1: Boundary Value Testing Acronyms
Acronym | Meaning
:-: | -
AUB | Above Upper Bound
UB | Upper Bound 
BUB | Below Upper Bound
NOM | A Nominal Value
ALB | Above Lower Bound
LB | Lower Bound
BLB | Below Lower Bound


Table 2: Assignment 2 Test Cases
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

Tables 3: Range Contains Test Cases
Partition | (Input) Value | (Output) Expected | (Output) Actual
--- | :-: | :-: | :-:
AUB| 101 | False | False
UB| 100 | True | True
BUB| 99 | True | True
NOM| 50 | True | True
ALB| 1 | True | True
LB| 0 | True | True 
BLB| -1 | False | False


Explanation:
The contains method takes a double value and returns true if the value falls within the boundaries of the range, else returns false. 
There are 3 Partitions for the input value, that is the valid nominal values between the lower and upper bound and the invalid values less than the lower and greater than the upper bound. For this function, taking scale in consideration Strong Robust ECT was applied to test all seven Boundary Values as outlined in table 1. All the test cases outlined in Table 3 was successful.

Code:


**org.jfree.data.Range.constrain**

Variables: Value
Constant Variables: Range with lowerbound = 0, upperbound = 100

Tables 4: Range Constrain Test Cases
Partition | (Input) Value | (Output) Expected | (Output) Actual
--- | :-: | :-: | :-:
AUB| 101 | 100 |  100
UB| 100 | 100 |  100
BUB| 99 | 99 | 99
NOM| 50 | 50 | 50
ALB| 1 | 1 | 1
LB| 0 | 0 | 0
BLB| -1 | 0 | 50


Explanation:
The constrain method takes a double value and returns the closest boundary value if the value is outside of the range or it will return the value itself if within the range.
There are 3 Partitions for the input value, that is the nominal values between the lower and upper bound and the invalid values less than the lower and greater than the upper bound. For this function, taking scale in consideration Strong Robust ECT was applied to test all seven Boundary Values as outlined in table 1. All but the BLB test case outlined in Table 4 was successful. This indicates that constrain method is improperly programed for negative values. 

Code:

**org.jfree.data.Range.equals**

Variables: Lowerbound, Upperbound
Constant Variables: Range with lowerbound = 0, upperbound = 100

Tables 5: Range Equals Test Cases
Partition | (Input) Lowerbound | (Input) Upperbound | (Output) Expected | (Output) Actual
--- | :-: | :-: | :-: | :-:
R.upperbound == T.upperbound && R.lowerbound == T.lowerbound | 0 | 100 | True | True
R.upperbound != T.upperbound && R.lowerbound == T.lowerbound | 0 | 101 | False | True
R.upperbound == T.upperbound && R.lowerbound != T.lowerbound | -1 | 100 | False | False
R.upperbound != T.upperbound && R.lowerbound != T.lowerbound | -1 | 101 | False | False


Explanation:
The equals method returns true if the input Range matches the Range it is being compare to.
There are 4 specific cases for the equals method (2 states ^ 2 variables), essentially checking the parity between the input lower and upper bound against the primary range's lower and upper bound.  For this method, taking scale in consideration Strong Robust ECT was applied. All but the 2nd test case outlined in Table 5 was successful. This indicates that equals method is improperly programmed for cases where the lower bound is correct but the upper bound is not. 

Code:

**org.jfree.data.Range.intersects**

Variables: Lowerbound, Upperbound
Constant Variables: Range with lowerbound = 0, upperbound = 100

Table 6: Range Intersects Test Cases
Partition | (Input) Lowerbound | (Input) Upperbound | (Output) Expected | (Output) Actual
--- | :-: | :-: | :-: | :-:
AUB| 101 | 151 | False | False
UB| 100 | 150 | True | True
BUB| 99 | 149 | True | True
NOM| 25 | 75 | True | True
ALB| -49 | 1 | True | True
LB| -50 | 0 | True | True
BLB| -51 | -1 | False | True


Explanation:
The intersects method returns true if either the input lower and upper bound (of type double) falls within the lower and upper bound of Range it is being compared to.
There are 3 Partitions for the input value, that is the nominal values between the lower and upper bound and the invalid values less than the lower and greater than the upper bound. For this function, taking scale in consideration Strong Robust ECT was applied to test all seven Boundary Values as outlined in table 1. All but the BLB test case outlined in Table 6 was successful. This indicates that intersects method is improperly programmed for when both input upper and lower bound is less than the lower bound of the Range. 

Code:

**org.jfree.data.Range.shift**

Variables: Delta
Constant Variables: Range with lowerbound = 0, upperbound = 100

Table 7: Range Shift Test Cases
Partition | (Input) Delta | (Output) Expected Lowerbound | (Output) Expected Upperbound | (Output) Actual Lowerbound | (Output) Actual Upperbound
--- | :-: | :-: | :-: | :-: | :-:
Negative Delta | -25 | -25 | 75 
Positive Delta | 25 | 25 | 125
Delta is Zero | 0 | 0 | 100

Explanation:
The shift method takes a double delta and an input Range and returns a new Range object that is the input Range shifted by the delta.
There are 3 cases for the input value, that is a zero, negative and positive shift. For this function, taking scale in consideration Strong Robust ECT was applied to test all three cases. All the test cases outlined in Table 7 was successful.

Code:

**org.jfree.data.DataUtilities.calculateColumnTotal**
**org.jfree.data.DataUtilities.calculateRowTotal**
**org.jfree.data.DataUtilities.createNumberArray**
**org.jfree.data.DataUtilities.createNumberArray2D**
**org.jfree.data.DataUtilities.getCumulativePercentages**

### Difficulties Encountered, Challenges Overcome, And Lessons Learned
This section outlines all difficulties that were encountered and overcome along with all the lessons learned. The largest difficulty encountered was understanding how to use jmock. By experimenting with the sample code provided along with reviewing the lecture 3 slides and minor research online this difficulty was overcomed. Similarly JUnit was difficult to use in the beginning because of it being new to the team. Similarly the inclusion of sample coding along with experimentation and lecture slide review help the team to overcome this issue.

There were several lessons learned:
1. How to use JUnit to set up and run tests.
2. How to use parameterized parameters to test multiple input values (useful for ECT)
3. How to use jmock to mimic the behaviour of complex interfaces in order to test methods that uses said interfaces.
4. In the case of jmock how to refer back to javadocs to understand what expectations need to be implemented in order to test methods.


### Comment / Feedback for the Lab Itself 
This was a fulfilling lab, it was difficult to begin and without lab periods as in previous semesters it is hard to be certain that the tests were being implmemented correctly. 

