package org.jfree.data.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    RangeConstrainTest.class,
    RangeContainsTest.class,
    RangeEqualsTest.class,
    RangeIntersectsTest.class,
    RangeShiftTest.class,
    DataUtilitiesTestCalculateColumnTotal.class,
    DataUtilitiesTestCalculateRowTotal.class,
    DataUtilitiesTestCreateNumberArray.class,
    DataUtilitiesTestCreateNumberArray2D.class,
    DataUtilitiesTestGetCumulativePercentages.class
})
public class JunitTestSuite {

}