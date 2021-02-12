
package org.jfree.data.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.jfree.data.Range;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/*
 * This test is for the shift method of Range. The ECT approach was utilized rationalize the proper tests. 
 */

@RunWith(Parameterized.class)
public class RangeShiftTest {

	private double firstNumber;
	private double expectedLowerBound;
	private double expectedUpperBound;
	private Range testRange;

	public RangeShiftTest(int firstNumber, double expectedLowerBound, double expectedUpperBound) {
		super();
		this.firstNumber = firstNumber;
		this.expectedLowerBound = expectedLowerBound;
		this.expectedUpperBound = expectedUpperBound;
	}

	@Before
	public void initialize() {
		testRange = new Range(0, 100);
	}

	// The input data is parameterized such that negative positive and zero delta
	// values were tested.

	@Parameterized.Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] { { -25, -25, 75 }, { 25, 25, 125 }, { 0, 0, 100 }, });
	}

	// This is used to test and evaluate the correctness of the lower bound.
	public void testLowerBound() {
		assertEquals(expectedLowerBound, Range.shift(testRange, firstNumber).getLowerBound(), 0.1);

	}

	// This is used to test and evaluate the correctness of the upper bound.
	public void testUpperBound() {
		assertEquals(expectedUpperBound, Range.shift(testRange, firstNumber).getUpperBound(), 0.1);
	}

	// This is the test function that calls the individual test functions of test
	// lowerbound and test upperbound.
	@Test
	public void testRangeShiftTest() {

		testLowerBound();
		testUpperBound();

	}

}
