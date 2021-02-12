package org.jfree.data.test;

import org.jfree.data.DataUtilities;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import java.lang.Number;

public class DataUtilitiesTestCreateNumberArray extends DataUtilities {

	double[] dataArray1;
	double[] dataArray2;
	double[] dataArray3;

	@Before
	public void setUp() {
		dataArray1 = new double[] {};
		dataArray2 = new double[] { 1.0 };
		dataArray3 = new double[] { 1.0, 2.0, 3.0, 4.0, 5.0 };
	}

	// partition an empty array
	@Test
	public void PartitionEmpty() {
		// DataUtilities.createNumberArray(double[] data)
		Number[] result1 = DataUtilities.createNumberArray(dataArray1);
		Assert.assertArrayEquals(new Number[] {}, result1);
	}

	// partition an array of size one
	@Test
	public void PartitionSizeOne() {
		// DataUtilities.createNumberArray(double[] data)
		Number[] result2 = DataUtilities.createNumberArray(dataArray2);
		Assert.assertArrayEquals(new Number[] { 1.0 }, result2);
	}

	
	// partition an array of size n
	@Test
	public void PartitionSizeN() {
		// DataUtilities.createNumberArray(double[] data)
		Number[] result3 = DataUtilities.createNumberArray(dataArray3);
		Assert.assertArrayEquals(new Number[] { 1.0, 2.0, 3.0, 4.0, 5.0 }, result3);
	}
}