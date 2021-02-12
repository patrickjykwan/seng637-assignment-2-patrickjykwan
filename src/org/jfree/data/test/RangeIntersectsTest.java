import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.jfree.data.Range;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/*
 * This test is for the constrain method of Range. The ECT approach was utilized to provide Strong Robust test.
 * This was Parameterized in order to test inputs for each of the 7 test cases in ECT.
 */

@RunWith(Parameterized.class)
public class RangeIntersectsTest {

	private double testLowerBound;
	private double testUpperBound;
	private boolean expectedResult;
	private Range testRange;

	public RangeIntersectsTest(double testLowerBound, double testUpperBound, boolean expectedResult) {
		super();
		this.testLowerBound = testLowerBound;
		this.testUpperBound = testUpperBound;
		this.expectedResult = expectedResult;

	}
	
	//Instiate a test range with known boundaries  of 0 and 100.
	@Before
	public void initialize() {
		testRange = new Range(0, 100);
	}
	
	
	//The input data is parameterized such that all BVT cases can be tested. That is in order of each input
	// Nominal, Lower Bound, Below Lower Bound, Above Lower Bound, Below Upper Bound, Upperbound, Above  Upperbound.
	@Parameterized.Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] { { 25, 75, true }, { -50, 0, true }, { -51, -1, false }, { -49, 1, true },
				{ 99, 149, true }, { 100, 150, true }, { 101, 151, false } });
	}


	 // An assertEquals was used to evaluate whether or not the test output matches the expectations.
	@Test
	public void testRangeShiftTest() {
		assertEquals(expectedResult, testRange.intersects(testLowerBound, testUpperBound));

	}

}
