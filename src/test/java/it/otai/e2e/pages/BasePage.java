package it.otai.e2e.pages;

import it.otai.e2e.configurations.OtaiE2EProperties;
import it.otai.e2e.common.CucumberHelper;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

abstract public class BasePage extends CucumberHelper {

    public static final int TIMEOUT = 4000;
    public static final int SHORT_WAIT = 2000;
    //2000
    public static final int ELEMENT_VISIBILITY_DELAY = 60;
    final protected OtaiE2EProperties otaiE2EProperties;

    protected BasePage(OtaiE2EProperties otaiE2EProperties) {
        this.otaiE2EProperties = otaiE2EProperties;
    }

    public boolean isElementPresent(By locator) {
        try {
            this.waitVisibilityOfElement(locator, ELEMENT_VISIBILITY_DELAY);
            getDriver().findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void maximizeScreenDimensions() {
        Dimension dimension = new Dimension(1920, 1080);
        getDriver().manage().window().setSize(dimension);
    }

    public void waitInvisibilityOfElement(By locator, long timeoutInSeconds) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitVisibilityOfElement(By locator, long timeoutInSeconds) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitElementToBeClickable(By locator, long timeoutInSeconds) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }


    public void waitMillis(long millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}