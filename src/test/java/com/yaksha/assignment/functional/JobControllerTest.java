package com.yaksha.assignment.functional;

import static com.yaksha.assignment.utils.TestUtils.businessTestFile;
import static com.yaksha.assignment.utils.TestUtils.currentTest;
import static com.yaksha.assignment.utils.TestUtils.testReport;
import static com.yaksha.assignment.utils.TestUtils.yakshaAssert;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.yaksha.assignment.utils.CustomParser;

public class JobControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testClassAnnotationsPresentInAppConfig() throws IOException {
		String filePath = "src/main/java/com/yaksha/assignment/config/AppConfig.java";

		boolean hasConfigurationAnnotation = CustomParser.checkClassAnnotation(filePath, "Configuration");
		boolean hasEnableWebMvcAnnotation = CustomParser.checkClassAnnotation(filePath, "EnableWebMvc");
		boolean hasComponentScanAnnotation = CustomParser.checkClassAnnotation(filePath, "ComponentScan");

		// Auto-grading with yakshaAssert
		yakshaAssert(currentTest(),
				hasConfigurationAnnotation && hasEnableWebMvcAnnotation && hasComponentScanAnnotation,
				businessTestFile);
	}

	@Test
	public void testClassAnnotationsPresentInJobController() throws IOException {
		String filePath = "src/main/java/com/yaksha/assignment/controller/JobController.java";

		boolean hasRestControllerAnnotation = CustomParser.checkClassAnnotation(filePath, "RestController");
		boolean hasRequestMappingAnnotation = CustomParser.checkClassAnnotation(filePath, "RequestMapping");

		yakshaAssert(currentTest(), hasRestControllerAnnotation && hasRequestMappingAnnotation, businessTestFile);
	}

	@Test
	public void testRequestMappingValue() throws IOException {
		String filePath = "src/main/java/com/yaksha/assignment/controller/JobController.java";

		boolean hasRequestMapping = CustomParser.checkClassAnnotationWithValue(filePath, "RequestMapping", "/api");
		yakshaAssert(currentTest(), hasRequestMapping, businessTestFile);
	}

	@Test
	public void testGetMappingValue() throws IOException {
		String filePath = "src/main/java/com/yaksha/assignment/controller/JobController.java";

		boolean hasGetMapping = CustomParser.checkMethodAnnotationWithValue(filePath, "GetMapping", "/jobs");
		yakshaAssert(currentTest(), hasGetMapping, businessTestFile);
	}

}
