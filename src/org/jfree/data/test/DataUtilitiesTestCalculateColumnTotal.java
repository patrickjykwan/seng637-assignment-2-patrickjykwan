package org.jfree.data.test;

import static junit.framework.Assert.*;
import org.jfree.data.Values2D;
import org.jfree.data.DataUtilities;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;
import org.junit.Before;

public class DataUtilitiesTestCalculateColumnTotal extends DataUtilities {

	private Mockery mockingContext;
	private Values2D values;

	@Before
	public void setUp() {
		mockingContext = new Mockery();
		values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{

				// initialize Values2D as so:
				// [ 1 1 1 ]
				// [ 2 2 2 ]
				// [ 3 3 3 ]

				oneOf(values).getValue(0, 0);
				will(returnValue(1));
				oneOf(values).getValue(1, 0);
				will(returnValue(2));
				oneOf(values).getValue(2, 0);
				will(returnValue(3));
				oneOf(values).getValue(0, 1);
				will(returnValue(1));
				oneOf(values).getValue(1, 1);
				will(returnValue(2));
				oneOf(values).getValue(2, 1);
				will(returnValue(3));
				oneOf(values).getValue(0, 2);
				will(returnValue(1));
				oneOf(values).getValue(1, 2);
				will(returnValue(2));
				oneOf(values).getValue(2, 2);
				will(returnValue(3));

				oneOf(values).getColumnCount();
				will(returnValue(3));
				oneOf(values).getRowCount();
				will(returnValue(3));
			}
		});
	}

	// partition a column index less than the first valid column index
	@Test
	public void PartitionLessThan() {

		// DataUtilities.calculateColumnTotal(Values2D values, ColumnIndex index)
		double result1 = DataUtilities.calculateColumnTotal(values, -1);
		assertEquals(0, result1, .000000001d);

	}
	
	// partition a column in the middle of the valid column index
	@Test
	public void PartitionWithin() {

		// DataUtilities.calculateColumnTotal(Values2D values, ColumnIndex index)
		double result2 = DataUtilities.calculateColumnTotal(values, 1);
		assertEquals(6, result2, .000000001d);
	}

	// partition a column greater than the last valid column index
	@Test
	public void PartitionGreaterThan() {

		// DataUtilities.calculateColumnTotal(Values2D values, ColumnIndex index)
		double result3 = DataUtilities.calculateColumnTotal(values, 3);
		assertEquals(0, result3, .000000001d);
	}
	
	
	// partition the first valid column index
	@Test 
	public void PartitionLowerBoundary() {
		
		// DataUtilities.calculateColumnTotal(Values2D values, ColumnIndex index)
		double result4 = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals(6, result4, .000000001d);
	}
	
	// partition the last valid column index
	@Test 
	public void PartitionUpperBoundary() {
		
		// DataUtilities.calculateColumnTotal(Values2D values, ColumnIndex index)
		double result5 = DataUtilities.calculateColumnTotal(values, 2);
		assertEquals(6, result5, .000000001d);
	}

}