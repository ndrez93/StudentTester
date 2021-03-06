package testcode;

import static org.junit.Assert.*;

import org.junit.Test;

import studentcode.StudentTesterExample;
import ee.ttu.java.studenttester.annotations.Gradeable;
import ee.ttu.java.studenttester.annotations.TestContextConfiguration;
import ee.ttu.java.studenttester.enums.ReportMode;

@TestContextConfiguration(mode = ReportMode.VERBOSE, welcomeMessage = "This file for demonstration purposes only.")
public class JUnitTest {

	StudentTesterExample se = new StudentTesterExample();
	
	// JUnit parameter order: assertEquals(expected, actual)
	
	@Test
	public void testSucceedNoAnnotation() {
		assertEquals(5, se.addNumbers(2, 3));
	}

	@Test
	public void testFailNoAnnotation() {
		assertEquals(5, se.addNumbersNotSoWell(2, 3));
	}
	
	@Test
	public void testCrashHorribly() {
		StudentTesterExample.crashHorribly();
	}

	@Gradeable(printExceptionMessage = true)
	@Test(timeout = 500)
	public void testHangHorribly() {
		StudentTesterExample.hangHorribly();
	}
	
	@Gradeable(description = "This is an annotated JUnit test. I should be visible in the report.")
	@Test
	public void testSucceedAnnotation() {
		assertEquals(5, se.addNumbers(2, 3));
	}

	@Gradeable(weight = 500)
	@Test
	public void testSucceedWeightedAnnotation() {
		assertEquals(5, se.addNumbers(2, 3));
	}
	
	@Gradeable(printStackTrace = true)
	@Test
	public void testCrashHorriblyWithStacktrace() {
		StudentTesterExample.crashHorribly();
	}
}
