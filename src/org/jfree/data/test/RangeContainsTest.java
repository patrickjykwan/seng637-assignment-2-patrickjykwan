import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class RangeContainsTest {

	private Range exampleRange;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@Before
	public void setUp() throws Exception {
		exampleRange = new Range(0, 100);
	}

	@Test
	public void containsNominalTest() {
		assertTrue(exampleRange.contains(50));
	}

	@Test
	public void containsLBTest() {
		assertTrue(exampleRange.contains(0));
	}

	@Test
	public void containsBLBTest() {
		assertFalse(exampleRange.contains(-1));
	}

	@Test
	public void containsALBTest() {
		assertTrue(exampleRange.contains(1));
	}

	@Test
	public void containsBUBTest() {
		assertTrue(exampleRange.contains(99));
	}

	@Test
	public void containUBBTest() {
		assertTrue(exampleRange.contains(100));
	}

	@Test
	public void containAUBTest() {
		assertFalse(exampleRange.contains(101));
	}

	@After
	public void tearDown() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}

}
