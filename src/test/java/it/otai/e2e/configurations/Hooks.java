package it.otai.e2e.configurations;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import it.otai.e2e.common.CucumberHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Date;

@Slf4j
public class Hooks extends CucumberHelper {

    @Autowired
    private OtaiE2EProperties otaiE2EProperties;


    public Hooks(OtaiE2EProperties otaiE2EProperties) {
        otaiE2EProperties = otaiE2EProperties;
    }

    @Before(order = 1)
    public void logStartTime(Scenario scenario) {
        scenario.log("Start time: " + new Date());
    }

    @Before(order = 2)
    public void setUp() throws IOException {
        getScenarioContext().clear();
        setDriver();
    }

    @After(order = 1)
    public void logEndTime(Scenario scenario) {
        scenario.log("End time: " + new Date());
        getScenarioContext().printScenarioMessages(scenario);
        scenario.log(getScenarioContext().toString());
    }

    @After(order = 2)
    public void tearDown(Scenario scenario) {
        //log.info("currentThread: {}", Thread.currentThread());
       // log.info("driver.getWindowHandle: {}", getDriver().getWindowHandle());
        if (scenario.isFailed()) {
            //final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            //scenario.attach(screenshot, "image/png", "screenshot");
        }
        quitDriver();
        removeScenarioContext();
    }
}



