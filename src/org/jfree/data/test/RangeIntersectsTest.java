import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.jfree.data.Range;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

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

	@Before
	public void initialize() {
		testRange = new Range(0, 100);
	}

	@Parameterized.Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] { { 25, 75, true }, { -50, 0, true }, { -51, -1, false }, { -49, 1, true },
				{ 99, 149, true }, { 100, 150, true }, { 101, 151, false } });
	}

	@Test
	public void testRangeShiftTest() {
		assertEquals(expectedResult, testRange.intersects(testLowerBound, testUpperBound));

	}

}
