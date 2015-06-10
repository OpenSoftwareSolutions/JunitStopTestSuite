package test.org.oss.junit.stoptestsuite;

import static org.junit.Assert.assertFalse;

import org.junit.BeforeClass;
import org.junit.Test;

public class StopOnFirstFailureTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		assertFalse(false);
	}

	@Test(expected=AssertionError.class)
	public void testStopOnFirstFailure() {
		assertFalse(true);
	}

}
