package it.otai.e2e.common;

import it.otai.e2e.configurations.E2EUsersProperties;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

@Slf4j
public class CucumberHelper {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final ThreadLocal<ScenarioContext> scenarioContext = new ThreadLocal<>();

    @Autowired
    private E2EUsersProperties usersProperties;

    protected E2EUsersProperties getUsersProperties() {
        return usersProperties;
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public void setDriver() {
        WebDriver chromeDriver = getChromeDriver();
        driver.set(chromeDriver);
    }

    protected void quitDriver() {
        if (getDriver() != null) {
            //getDriver().quit();
            //driver.remove();
        }
    }

    public static ScenarioContext getScenarioContext() {
        if (Objects.isNull(scenarioContext.get())) {
            scenarioContext.set(new ScenarioContext());
        }
        return scenarioContext.get();
    }

    protected static void removeScenarioContext() {
        scenarioContext.remove();
    }

    public ChromeDriver getChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en")
                .addArguments("--start-maximized")
                .addArguments("--no-sandbox")
                .addArguments("--disable-dev-shm-usage")
                .addArguments("--disable-extensions")
                .addArguments("--disable-touch-events");
       // log.info("Chrome options:\n{}", options);
        return new ChromeDriver(options);
    }

}