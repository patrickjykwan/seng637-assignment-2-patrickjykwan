package org.jfree.data.test;

import org.jfree.data.KeyedValues;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.DataUtilities;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import java.util.Arrays;

public class DataUtilitiesTestGetCumulativePercentages extends DataUtilities {

	private Mockery mockingContext1;
	private Mockery mockingContext2;
	private Mockery mockingContext3;

	private KeyedValues values1;
	private KeyedValues values2;
	private KeyedValues values3;

	@Before
	public void setUp1() {
		mockingContext1 = new Mockery();
		
		// empty
		values1 = mockingContext1.mock(KeyedValues.class);
		mockingContext1.checking(new Expectations() {
			{
				allowing(values1).getKeys();
				will(returnValue(Arrays.asList()));
				allowing(values1).getItemCount();
				will(returnValue(0));
			}
		});
	}

	@Before
	public void setUp2() {
		// one entry
		mockingContext2 = new Mockery();
		values2 = mockingContext2.mock(KeyedValues.class);
		mockingContext2.checking(new Expectations() {
			{
				allowing(values2).getKeys();
				will(returnValue(Arrays.asList(0)));

				allowing(values2).getKey(0);
				will(returnValue(0));
				allowing(values2).getIndex(0);
				will(returnValue(0));
				allowing(values2).getValue(0);
				will(returnValue(5));

				allowing(values2).getItemCount();
				will(returnValue(1));
			}
		});
	}

	@Before
	public void setUp3() {
		// n entries
		mockingContext3 = new Mockery();
		values3 = mockingContext3.mock(KeyedValues.class);
		mockingContext3.checking(new Expectations() {
			{
				allowing(values3).getKeys();
				will(returnValue(Arrays.asList(0, 1, 2)));

				allowing(values3).getKey(0);
				will(returnValue(0));
				allowing(values3).getIndex(0);
				will(returnValue(0));
				allowing(values3).getValue(0);
				will(returnValue(5));

				allowing(values3).getKey(1);
				will(returnValue(1));
				allowing(values3).getIndex(1);
				will(returnValue(1));
				allowing(values3).getValue(1);
				will(returnValue(9));

				allowing(values3).getKey(2);
				will(returnValue(2));
				allowing(values3).getIndex(2);
				will(returnValue(2));
				allowing(values3).getValue(2);
				will(returnValue(2));
				
				allowing(values3).getItemCount();
				will(returnValue(3));
			}
		});
	}

	// Partition an empty KeyedValues object
	@Test
	public void PartitionEmpty() {
		DefaultKeyedValues expected1 = new DefaultKeyedValues();
		
		// DataUtilities.getCumulativePercentages(KeyedValues data)
		KeyedValues result1 = DataUtilities.getCumulativePercentages(values1);
		Assert.assertEquals(expected1, result1);
	}

	// Partition a KeyedValues object with one entry
	@Test
	public void PartitionOneEntry() {	
		DefaultKeyedValues expected2 = new DefaultKeyedValues();
		expected2.addValue((Comparable<Integer>)0, (double)1.0);
		
		// DataUtilities.getCumulativePercentages(KeyedValues data)
		KeyedValues result2 = DataUtilities.getCumulativePercentages(values2);
		Assert.assertEquals(expected2, result2);
	}

	// Partition a KeyedValues object with N entries
	@Test
	public void PartitionNEntries() {
		DefaultKeyedValues expected3 = new DefaultKeyedValues();
		expected3.addValue((Comparable<Integer>)0, (double)0.3125);
		expected3.addValue((Comparable<Integer>)1, (double)0.875);
		expected3.addValue((Comparable<Integer>)2, (double)1.0);
		
		// DataUtilities.getCumulativePercentages(KeyedValues data)
		KeyedValues result3 = DataUtilities.getCumulativePercentages(values3);
		Assert.assertEquals(expected3, result3);
	}
}