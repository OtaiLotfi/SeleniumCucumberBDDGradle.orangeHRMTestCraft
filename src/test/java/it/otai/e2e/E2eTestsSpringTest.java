package it.otai.e2e;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * This class is needed because cucumber-spring is in the classpath
 */
@CucumberContextConfiguration
@SpringBootTest(classes = E2eTestsSpringApplication.class)
public class E2eTestsSpringTest {

}