package com.topcoder.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({})
public class AllTests {

	@RunWith(Suite.class)
	@Suite.SuiteClasses({
	   ABBATest.class,
	   A0PaperTest.class
	})
	public class JunitTestSuite {   
	}
	
}
