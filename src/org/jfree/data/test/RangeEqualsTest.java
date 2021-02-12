package org.jfree.data.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.jfree.data.Range;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


/*
 * This test is for the equals method of Range. The ECT approach was utilized to provide Strong Robust test.
 */

@RunWith(Parameterized.class)
public class RangeEqualsTest {
	
	
	private Range comparisonRange;
	private boolean expectedResult; 
	private Range testRange;
	
	public RangeEqualsTest(Range comparisonRange,boolean expectedResult) {
		super();
		this.comparisonRange=comparisonRange;
		this.expectedResult = expectedResult;
		
	}
	
	//A Range object is created constrain to boundary values of 0 and 100.
	
	@Before
	public void initialize() {
		testRange = new Range(0, 100);
	}
	
	//The input data is parameterized to input values that test the parity of the lower and upper bounds of the test Range using another Range object.
	// 
	@Parameterized.Parameters
	  public static Collection data() {
	      return Arrays.asList(new Object[][] { { new Range(-1,101), false }, { new Range(0,101), false }, { new Range(-1,100), false }, {new Range(0,100), true}
	                  });
	 }
	

	//Assert Equal was used to test the parity between matching and non matching ranges.
	@Test
	public void testRangeShiftTest() {
		
		assertEquals(expectedResult, testRange.equals(comparisonRange));	
		
	}
	

	
	
}


