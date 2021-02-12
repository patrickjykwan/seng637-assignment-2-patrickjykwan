package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

/*
 * This test is for the contain method of Range. The ECT approach was utilized to provide Strong Robust test.
 * This was the first test that was programmed without using parameterized parameters.
 */
public class RangeContainsTest {

	private Range exampleRange;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}
	
	// Here the Range is instanitated with the boundaries of 0 and 100

	@Before
	public void setUp() throws Exception {
		exampleRange = new Range(0, 100);
	}

	// The following tests corresponds to the ECT test cases and are properly named.  
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
