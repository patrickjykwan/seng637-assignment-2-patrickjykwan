import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.jfree.data.Range;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

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
	
	@Before
	public void initialize() {
		testRange = new Range(0, 100);
	}
	
	@Parameterized.Parameters
	  public static Collection data() {
	      return Arrays.asList(new Object[][] { { new Range(-1,101), false }, { new Range(0,101), false }, { new Range(-1,100), false }, {new Range(0,100), true}
	                  });
	 }
	

	
	@Test
	public void testRangeShiftTest() {
		
		assertEquals(expectedResult, testRange.equals(comparisonRange));	
		
	}
	

	
	
}


