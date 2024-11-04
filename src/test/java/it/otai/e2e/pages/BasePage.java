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
            this.waitMillis(TIMEOUT);
            return !getDriver().findElements(locator).isEmpty();
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


    public void waitForElementCountToDecrease(By locator, int initialCount, long timeoutInSeconds) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.numberOfElementsToBeLessThan(locator, initialCount));
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

    public void scrollThePage() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        for (int i = 0; i < 10; i++) {
            js.executeScript("window.scrollBy(0, 100)");
            Thread.sleep(500);
        }

        for (int i = 0; i < 10; i++) {
            js.executeScript("window.scrollBy(0, -100)");
            Thread.sleep(500);
        }
    }

    public void clickOn(String buttonLabel) {
        this.waitMillis(SHORT_WAIT + SHORT_WAIT);
        By buttonXpath = By.xpath("//*/button[text()='" + buttonLabel + "']");
        this.waitVisibilityOfElement(buttonXpath, ELEMENT_VISIBILITY_DELAY);
        WebElement buttonField = getDriver().findElement(buttonXpath);
        buttonField.click();
    }

    public void scrollToTheTopOfThePage() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, 0)");
    }
}