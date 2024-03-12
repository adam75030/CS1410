package lab04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestingPracticeTest {
		
	@Test
	void testCamelCaseNormalString() {
		String result = TestingPractice.camelCase("hello world");
		assertEquals("helloWorld", result, "camelCase failed for normal String");
	}
	
	@Test
	void testCamelCaseEmptyString() {
		String result = TestingPractice.camelCase("");
		assertEquals("", result, "camelCase failed for empty String");
	}
	
	@Test
	void testCamelCaseNumbers() {
		String result = TestingPractice.camelCase("1 2 3 !@#$");
		assertEquals("123!@#$", result, "camelCase failed for numbers input");
	}

}
