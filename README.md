

## SENG 637: Dependability and Reliability of Software Systems

# Lab. Report #2: Requirements - Based Test Generation

Group Number: 4 | Digit | Character
:------: | :------:|:----------:
John Van Heurn | #30001886 | john.vanheurn1@ucalgary.ca
Patrick Kwan | #10103093 | pjykwan@ucalgary.ca
 
---

### Introduction

This is the second lab of SENG 637: Dependability and Reliability of Software Systems. This lab is an introduction to automated unit testing with specified requirements for each test unit. The JUnit framework will be utilized to test methods from 2 classes, org.jfree.data.Range and org.jfree.data.DataUtilities, in the JFreeChart framework, and the test results will be displayed.


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
DataUtilities.calculateColumnTotal | Column | (When Referenced to Constant Value2D Object) <div><b>(Column < 0),<b><div><div><b>(Column == 0)<b><div><div><b>(Column > 0 && Column < # of Columns)<b><div><div><b>(Column == # of Columns)<div><b><div><b>and (Column > # of Columns)<b><div>
DataUtilities.calculateRowTotal | Row | (When Referenced to Constant Value2D Object) <div><b>(Row < 0),<b><div><b><div>(Row == 0)<div><b><div><b>(Row > 0 && Row < # of Rows)<b><div><b><div><div><b>(Row = # of Rows
)<div><b>and (Row > # of Rows)<b><div>
DataUtilities.createNumberArray | Data Array | **Empty Array, Array of Size 1, Array of Size n**
DataUtilities.createNumberArray2D | Data 2D Array | **Empty Array, 1x1 Array, Column Array (1xn), Row Array(nx1), nxn Array**
DataUtilities.getCumulativePercentages | Data | **Empty KeyedValues data, KeyedValues 1 data entry, KeyedValues n data entries**

Additional clarification on the exact tests will be shown in the following section.

---

### How the Team Work / Effort was Divided and Managed

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

Code: <https://github.com/patrickjykwan/seng637-assignment-2-patrickjykwan/blob/main/src/org/jfree/data/test/RangeContainsTest.java>


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

Code: <https://github.com/patrickjykwan/seng637-assignment-2-patrickjykwan/blob/main/src/org/jfree/data/test/RangeConstrainTest.java>


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

Code: <https://github.com/patrickjykwan/seng637-assignment-2-patrickjykwan/blob/main/src/org/jfree/data/test/RangeEqualsTest.java>

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

Code: <https://github.com/patrickjykwan/seng637-assignment-2-patrickjykwan/blob/main/src/org/jfree/data/test/RangeIntersectsTest.java>


**org.jfree.data.Range.shift**

Variables: Delta
Constant Variables: Range with lowerbound = 0, upperbound = 100

Table 7: Range Shift Test Cases
Partition | (Input) Delta | (Output) Expected Lowerbound | (Output) Expected Upperbound | (Output) Actual Lowerbound | (Output) Actual Upperbound
--- | :-: | :-: | :-: | :-: | :-:
Negative Delta | -25 | -25 | 75 | -25 | 75
Positive Delta | 25 | 25 | 125 | 25 | 125
Delta is Zero | 0 | 0 | 100 | 0 | 100

Explanation:

The shift method takes a double delta and an input Range and returns a new Range object that is the input Range shifted by the delta.
There are 3 cases for the input value, that is a zero, negative and positive shift. For this function, taking scale in consideration Strong Robust ECT was applied to test all three cases. All the test cases outlined in Table 7 was successful.

Code: <https://github.com/patrickjykwan/seng637-assignment-2-patrickjykwan/blob/main/src/org/jfree/data/test/RangeShiftTest.java>

**org.jfree.data.DataUtilities.calculateColumnTotal**

Variables: Column
Mocked Variables: 

Values2D Object:  
[1 1 1]
[2 2 2]
[3 3 3]

Table 8: Calculate Column Total Test Cases

Partition | (Input) Column | (Output) Expected | (Output) Actual
--- | :-: | :-: | :-: | :-:
Column < 0 | -1 | 0 | Exception: Expected Out of Bounds Value Invocations
Column == 0 | 0 | 6 | 6
Column >= 0 && Column <= # of Columns | 1 | 6 | 6
Column == # of Columns | 2 | 6 | 6
Column > # of Columns | 3 | 0 | Exception: Expected Out of Bounds Value Invocations

Explanation: 

The calculateColumnTotal function requires an input of column index and a object that implements the Values2D interface, and returns the summation of that column. There are five partitions to utilize a Robust ECT format that covers an index of below lower bound, at lower bound, nominal, at upper bound, and above upper bound of the Values2D object. It was found that if the input column index was out of bounds of the Values2D object, the function does not perform boundary checks and calls a getter function to iterate through the rows of any input column. Otherwise, if a valid column index was entered, the test would pass.

Overall, two out of the five test cases above failed.

Code: <https://github.com/patrickjykwan/seng637-assignment-2-patrickjykwan/blob/main/src/org/jfree/data/test/DataUtilitiesTestCalculateColumnTotal.java>

**org.jfree.data.DataUtilities.calculateRowTotal**

Variables: Row
Mocked Variables: 

Values2D Object:  
[1 1 1]
[2 2 2]
[3 3 3]

Table 9: Calculate Row Total Test Cases

Partition | (Input) Row | (Output) Expected | (Output) Actual
--- | :-: | :-: | :-: | :-:
Row < 0 | -1 | 0 | Exception: Expected Out of Bounds Value Invocations
Row == 0 | 0 | 3 | 2
Row > 0 && Row < # of Rows | 1 | 6 | 4
Row == # of Rows | 2 | 9 | 6 
Row > # of Rows | 3 | 0 | Exception: Expected Out of Bounds Value Invocations

Explanation:

Similar to calculateColumnTotal, the calculateRowTotal function requires an input of row index and a object that implements the Values2D interface, and returns a summation of that row. Using five partitions for a Robust ECT format that covers an index of below lower bound, at lower bound, nominal, at upper bound, and above upper bound of the Values2D object. It was found that the the calculateRowTotal function does not add the value of one of the columns to the total, and thus outputting the wrong solution. In addition, the function does not perform boundary checks and calls a getter function to iterate through the columns of any input row.

Overall, all of the five test cases above failed.

Code: <https://github.com/patrickjykwan/seng637-assignment-2-patrickjykwan/blob/main/src/org/jfree/data/test/DataUtilitiesTestCalculateRowTotal.java>

**org.jfree.data.DataUtilities.createNumberArray**

Variables: Data Array of varying sizes

Table 10: Create Number Array Test Cases

Partition | (Input) Data[] | (Output) Expected Number[] | (Output) Actual Number[]
--- | :-: | :-: | :-:
Empty Array | {} | {} | {}
Size 1 Array | {1.0} | {1.0} | Element[0]: Expected 1.0 but was null
Size n Array | {1.0, 2.0, 3.0, 4.0, 5.0} | {1.0, 2.0, 3.0, 4.0, 5.0} | Element[4]: Expected 5.0 but was null

Explanation:

The createNumberArray function takes an input of a 1D double array, and outputs the corresponding 1D Number array. Three partitions were used that had a data array of size zero, size one, and size n. Upon testing, it was found that with non-empty arrays, the function does not copy the last element of the array, resulting a test failure when expecting a value but receiving a null value at the last index. Here, two out of the three test cases failed.

Code: <https://github.com/patrickjykwan/seng637-assignment-2-patrickjykwan/blob/main/src/org/jfree/data/test/DataUtilitiesTestCreateNumberArray.java>

**org.jfree.data.DataUtilities.createNumberArray2D**

Variables: 2D Data Array of varying sizes

Table 11: Create Number Array 2D Test Cases

Partition | (Input) Data[][] | (Output) Expected Number[][] | (Output) Actual Number[][]
--- | :-: | :-: | :-:
Empty Array | { { } } | { { } } | { { } }
Size 1x1 Array | { { 1.0 } } | { { 1.0 } } | Element[0][0]: Expected 1.0 but was null
Column Array | { { 1.0 }, { 2.0 }, { 3.0 }, { 4.0 }, { 5.0 } } | { { 1.0 }, { 2.0 }, { 3.0 }, { 4.0 }, { 5.0 } } | Element[0][0]: Expected 1.0 but was null
Row Array | { { 1.0, 2.0, 3.0, 4.0, 5.0 } } | { { 1.0, 2.0, 3.0, 4.0, 5.0 } } | Element[0][4]: Expected 5.0 but was null
nxn Array | { { 1.0, 2.0, 3.0, 4.0, 5.0 }, { 1.0, 2.0, 3.0, 4.0, 5.0 }, { 1.0, 2.0, 3.0, 4.0, 5.0 }, { 1.0, 2.0, 3.0, 4.0, 5.0 }, { 1.0, 2.0, 3.0, 4.0, 5.0 } } | { { 1.0, 2.0, 3.0, 4.0, 5.0 }, { 1.0, 2.0, 3.0, 4.0, 5.0 }, { 1.0, 2.0, 3.0, 4.0, 5.0 }, { 1.0, 2.0, 3.0, 4.0, 5.0 }, { 1.0, 2.0, 3.0, 4.0, 5.0 } } | Element[0][4]: Expected 5.0 but was null

Explanation:

Similar to the createNumberArray function, the createNumberArray2D function had the same issues. Five partitions were used that had a 2D data array of size 0x0, 1x1, 1xn, nx1, and nxn. Upon tesing, it was found that with non-empty 2D arrays, the function does not copy the last element of each row, resulting in a test failure when expecting a value but receiving a null value at the last index of any given row. Here, four out of five test cases failed.

Code: <https://github.com/patrickjykwan/seng637-assignment-2-patrickjykwan/blob/main/src/org/jfree/data/test/DataUtilitiesTestCreateNumberArray2D.java>


**org.jfree.data.DataUtilities.getCumulativePercentages**

Variables: Data in the form of KeyedValues

Table 12: Get Cumulative Percentages Test Cases

Partition | (Input) Data[] | (Output) Expected Data[] | (Output) Actual Data[]
--- | :-: | :-: | :-:
Empty KeyedValues | {{}} | {{}} | {{}}
1 Entry KeyedValues | {{0, 5}} | {{0, 1.0}} | {{1, infinity}}
n Entries KeyedValues | {{0, 5}, {1, 9}, {2, 2}} | {{0, 0.3125}, {1, 0.875}, {2, 1.0}} | {{0, 0.4545}, {1, 1.2727, {2, 1.4545}}


Explanation:

Upon testing of the getCumulativePercentages function, it was found that the arithmetic was not being performed correctly. Three partitions were used that had a KeyedValues object with zero entries, 1 entry, and n entries. With this function called on a KeyedValues object with one entry, the output is a key with a value of infinity; which occurs when a number is divided by zero in Java. Therefore, the denominator used in the calculations is not being calculated properly.

Code: <https://github.com/patrickjykwan/seng637-assignment-2-patrickjykwan/blob/main/src/org/jfree/data/test/DataUtilitiesTestGetCumulativePercentages.java>


### Difficulties Encountered, Challenges Overcome, And Lessons Learned
This section outlines all difficulties that were encountered and overcome along with all the lessons learned. The largest difficulty encountered was understanding how to use jmock. By experimenting with the sample code provided along with reviewing the lecture 3 slides and minor research online this difficulty was overcomed. Similarly JUnit was difficult to use in the beginning because of it being new to the team. The inclusion of sample coding along with experimentation and lecture slide review help the team to overcome this issue.

There were several lessons learned:
1. How to use JUnit to set up and run tests.
2. How to use parameterized parameters to test multiple input values (useful for ECT)
3. How to use jmock to mimic the behaviour of complex interfaces in order to test methods that uses said interfaces.
4. In the case of jmock how to refer back to javadocs to understand what expectations need to be implemented in order to test methods.

It became apparent through testing that JUnit and specifically JMock needs to be implemented correctly to have a valuable test output. Mocking interfaces requires knowledge of how the function under test works, and requires precise code to mimic the functions that the SUT calls. If this code is not accurate, then the result will not be useful. Therefore, mocking can introduce additional bugs into your test scenario and give a false perception of what is wrong or what isn't wrong with the SUT. By hard programming the return of called functions within the SUT function, we can test its functionality. But what if the SUT function does not use the functions that the tester thinks it does? Within this lab, the group did not have access to the source code, and needed to assume based on the provided API how particular functions operated. This is a problem, because unknowingly, we may not have mocked everything that the SUT needed to be mocked and this introduces errors.


### Comment / Feedback for the Lab Itself 
This was a fulfilling lab, it was difficult to begin and without lab periods as in previous semesters it is hard to be certain that the tests were being implmemented correctly. 

This lab was a good learning experience because it forces the students to implement a testing framework that utilizes mocking and allows students to experience first-hand where mocking excels and where mocking might excel.