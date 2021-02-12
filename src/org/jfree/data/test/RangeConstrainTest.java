package org.jfree.data.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.jfree.data.Range;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/*
 * This test is for the constrain method of Range. The ECT approach was utilized to provide Strong Robust test.
 */

@RunWith(Parameterized.class)
public class RangeConstrainTest {
	private double firstNumber;
	private double expectedResult;
	private Range testRange;
	
	public RangeConstrainTest(int firstNumber, double expectedResult) {
		super();
		this.firstNumber=firstNumber;
		this.expectedResult=expectedResult;
	}
	
	@Before
	public void initialize() {
		testRange = new Range(0, 100);
	}
	
	//The input data is parameterized such that all BVT cases can be tested. That is in order of each input
	// Nominal, Lower Bound, Below Lower Bound, Above Lower Bound, Below Upper Bound, Upperbound, Above  Upperbound.
	  @Parameterized.Parameters
	  public static Collection data() {
	      return Arrays.asList(new Object[][] { { 50, 50 }, { 0, 0 }, { -1, 0 },
	                 { 1, 1 }, { 99, 99 }, { 100, 100 }, { 101, 100 } });
	 }
	  
	  //Messages were output for reference. An assertEquals was used to evaluate whether or not the test output matches the expectations.
		@Test
		public void testRangeConstrainTest() {
			assertEquals(expectedResult, testRange.constrain(firstNumber), 0.00001);
		}
		  

}
