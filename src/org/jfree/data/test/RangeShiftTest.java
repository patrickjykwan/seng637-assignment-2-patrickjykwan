import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.jfree.data.Range;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class RangeShiftTest {
	
	private double firstNumber;
	private double expectedLowerBound;
	private double expectedUpperBound;
//	private Range expectedRange;
	private Range testRange;
	
	public RangeShiftTest(int firstNumber, double expectedLowerBound, double expectedUpperBound) {
		super();
		this.firstNumber=firstNumber;
		this.expectedLowerBound = expectedLowerBound;
		this.expectedUpperBound = expectedUpperBound;
	}
	
	@Before
	public void initialize() {
		testRange = new Range(0, 100);
	}
	
	@Parameterized.Parameters
	  public static Collection data() {
	      return Arrays.asList(new Object[][] { { -25, -25, 75 }, { 25, 25, 125 }, { 0, 0, 100 },
	                  });
	 }
	
	public void testLowerBound() {
		System.out.println("Lowerbound: "+ Range.shift(testRange, firstNumber).getLowerBound());
		System.out.println("Expected Lowerbound: "+ expectedLowerBound);
		assertEquals(expectedLowerBound, Range.shift(testRange, firstNumber).getLowerBound(), 0.1);
		
	}
	
	public void testUpperBound() {
		System.out.println("Upperbound: "+ Range.shift(testRange, firstNumber).getUpperBound());
		System.out.println("Expected Upperbound: "+ expectedUpperBound);
		assertEquals(expectedUpperBound, Range.shift(testRange, firstNumber).getUpperBound(), 0.1);
		
		
	}
	
	@Test
	public void testRangeShiftTest() {
		//System.out.println("expectedL = " + expectedLowerBound + " expectedU = " + expectedUpperBound);
		//assertEquals(expectedLowerBound, Range.shift(testRange, firstNumber).getLowerBound(), 0.1);
		testLowerBound();
		//assertEquals(expectedUpperBound, Range.shift(testRange, firstNumber).getUpperBound(), 0.1);
		//testUpperBound();
		
	}
	

	
	
}
