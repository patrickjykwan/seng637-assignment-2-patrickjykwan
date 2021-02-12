import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.jfree.data.Range;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/*
 * This constrain testing needs to be reconsidered. For some reason the results must be typecast into an int for it to be true.
 * Leaving is as a double results in an error even though the results matches.The solution is to actually use the tolerance 
 * setting!
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
	
	  @Parameterized.Parameters
	  public static Collection data() {
	      return Arrays.asList(new Object[][] { { 50, 50 }, { 0, 0 }, { -10, 0 },
	                 { 1, 1 }, { 99, 99 }, { 100, 100 }, { 101, 100 } });
	 }
	  
		@Test
		public void testRangeConstrainTest() {
			System.out.println("input = " + firstNumber + "expected = " + expectedResult + " output = " + testRange.constrain(expectedResult));
			assertEquals(expectedResult, testRange.constrain(firstNumber), 0.00001);
			//assertTrue(testRange.contains(firstNumber));
		}
		  

}
