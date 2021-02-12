package org.jfree.data.test;

import org.jfree.data.DataUtilities;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import java.lang.Number;

public class DataUtilitiesTestCreateNumberArray2D extends DataUtilities {

	double[][] dataArray1;
	double[][] dataArray2;
	double[][] dataArray3;
	double[][] dataArray4;
	double[][] dataArray5;

	@Before
	public void setUp() {
		dataArray1 = new double[][] { {} };
		dataArray2 = new double[][] { { 1.0 } };
		dataArray3 = new double[][] { { 1.0, 2.0, 3.0, 4.0, 5.0 } };
		dataArray4 = new double[][] { { 1.0 }, { 2.0 }, { 3.0 }, { 4.0 }, { 5.0 } };
		dataArray5 = new double[][] { { 1.0, 2.0, 3.0, 4.0, 5.0 }, { 1.0, 2.0, 3.0, 4.0, 5.0 },
				{ 1.0, 2.0, 3.0, 4.0, 5.0 }, { 1.0, 2.0, 3.0, 4.0, 5.0 }, { 1.0, 2.0, 3.0, 4.0, 5.0 } };
	}

	@Test
	public void PartitionEmpty() {
		// DataUtilities.createNumberArray2D(double[][] data)
		Number[][] result1 = DataUtilities.createNumberArray2D(dataArray1);
		Assert.assertArrayEquals(new Number[][] { {} }, result1);
	}

	@Test
	public void PartitionSizeOnexOne() {
		// DataUtilities.createNumberArray2D(double[][] data)
		Number[][] result2 = DataUtilities.createNumberArray2D(dataArray2);
		Assert.assertArrayEquals(new Number[][] { { 1.0 } }, result2);
	}

	@Test
	public void PartitionSizeOnexN() {
		// DataUtilities.createNumberArray2D(double[][] data)
		Number[][] result3 = DataUtilities.createNumberArray2D(dataArray3);
		Assert.assertArrayEquals(new Number[][] { { 1.0, 2.0, 3.0, 4.0, 5.0 } }, result3);
	}

	@Test
	public void PartitionSizeNxOne() {
		// DataUtilities.createNumberArray2D(double[][] data)
		Number[][] result4 = DataUtilities.createNumberArray2D(dataArray4);
		Assert.assertArrayEquals(new Number[][] { { 1.0 }, { 2.0 }, { 3.0 }, { 4.0 }, { 5.0 } }, result4);
	}

	@Test
	public void PartitionSizeNxN() {
		// DataUtilities.createNumberArray2D(double[][] data)
		Number[][] result5 = DataUtilities.createNumberArray2D(dataArray5);
		Assert.assertArrayEquals(new Number[][] { { 1.0, 2.0, 3.0, 4.0, 5.0 }, { 1.0, 2.0, 3.0, 4.0, 5.0 },
				{ 1.0, 2.0, 3.0, 4.0, 5.0 }, { 1.0, 2.0, 3.0, 4.0, 5.0 }, { 1.0, 2.0, 3.0, 4.0, 5.0 } }, result5);
	}
}