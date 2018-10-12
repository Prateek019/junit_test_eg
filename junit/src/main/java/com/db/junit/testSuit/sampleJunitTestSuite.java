package com.db.junit.testSuit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.db.junit.CustomerTest2;
import com.db.junit.test.CustomerTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	CustomerTest.class,
	CustomerTest2.class
})
public class sampleJunitTestSuite {

}
