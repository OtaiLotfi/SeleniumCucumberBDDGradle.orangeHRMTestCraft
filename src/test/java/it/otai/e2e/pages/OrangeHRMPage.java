package it.otai.e2e.pages;

import it.otai.e2e.configurations.OtaiE2EProperties;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class OrangeHRMPage extends BasePage {
    private final OtaiE2EProperties otaiE2EProperties;
    public static final int SCROLL_AMOUNT = 200;
    private final int CHILD_ROW = 1;

    protected OrangeHRMPage(OtaiE2EProperties otaiE2EProperties) {
        super(otaiE2EProperties);
        this.otaiE2EProperties = otaiE2EProperties;
    }

    public void openFromTheMenu(String itemLabel) {
        this.waitMillis(SHORT_WAIT);
        By itemLabelXpath = By.xpath("//*/li/a/span[text()='" + itemLabel + "']");
        this.waitVisibilityOfElement(itemLabelXpath, ELEMENT_VISIBILITY_DELAY);
        WebElement itemField = getDriver().findElement(itemLabelXpath);
        itemField.click();
    }

    public void selectAllRecordsOnTheLeftBasedOn(String columnHeaderName) {
        By selectAllXpath = By.xpath("//*/div[text()='" + columnHeaderName + "']/preceding-sibling::div//label");
        this.waitElementToBeClickable(selectAllXpath, ELEMENT_VISIBILITY_DELAY);
        WebElement inputCheckbox = getDriver().findElement(selectAllXpath);
        inputCheckbox.click();
    }

    public void clickOn(String buttonLabel) {
        this.waitMillis(SHORT_WAIT + SHORT_WAIT);
        By buttonXpath = By.xpath("//*/button[text()='" + buttonLabel + "']");
        this.waitVisibilityOfElement(buttonXpath, ELEMENT_VISIBILITY_DELAY);
        WebElement buttonField = getDriver().findElement(buttonXpath);
        buttonField.click();
    }

    public int countRows(By parentRowGroupXpath) {
        WebElement parentRowGroupElement = getDriver().findElement(parentRowGroupXpath);
        List<WebElement> childElements = parentRowGroupElement.findElements(By.xpath("./*"));
        return childElements.size();
    }

    public void deleteRecords(By parentRowGroupXpath) {
        this.waitMillis(SHORT_WAIT);
        if (CHILD_ROW < this.countRows(parentRowGroupXpath)) {
            this.clickOn(" Delete Selected ");
            this.waitMillis(SHORT_WAIT);
            this.clickOn(" Yes, Delete ");
        }
    }

    public void clickOnFromTheTopBar(String topBarItem) {
        this.waitMillis(SHORT_WAIT);
        By topBarItemXpath = By.xpath("//*[text()='" + topBarItem + "']");
        this.waitVisibilityOfElement(topBarItemXpath, ELEMENT_VISIBILITY_DELAY);
        WebElement topBarItemField = getDriver().findElement(topBarItemXpath);
        topBarItemField.click();
    }

    public void enterTheFor(String reportName, String nameValue) {
        this.waitMillis(SHORT_WAIT);
        By inputReportNameXpath = By.xpath("//*/label[contains(text(),'" + reportName + "')]/../..//input");
        this.waitVisibilityOfElement(inputReportNameXpath, ELEMENT_VISIBILITY_DELAY);
        WebElement inputReportNameField = getDriver().findElement(inputReportNameXpath);
        inputReportNameField.click();
        inputReportNameField.sendKeys(nameValue + this.getFormattedDateTime());
    }

    public String getFormattedDateTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        return currentDateTime.format(formatter);
    }

    public void selectTheWrapperFor(String wrapperLabel, String inputValue) {
        this.waitMillis(SHORT_WAIT);
        By wrapperXpath = By.xpath("//*/label[contains(text(),'" + wrapperLabel + "')]/../../div[2]//i");
        this.waitVisibilityOfElement(wrapperXpath, ELEMENT_VISIBILITY_DELAY);
        WebElement wrapperField = getDriver().findElement(wrapperXpath);
        wrapperField.click();
        this.scrollFromListItems(inputValue).click();
    }

    public WebElement scrollFromListItems(String inputLabel) {
        this.waitMillis(SHORT_WAIT);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        By dropdownItemXpath = By.xpath("//*[contains(text(), '" + inputLabel + "')]");
        WebElement employeeNameOption = getDriver().findElement(dropdownItemXpath);
        js.executeScript("arguments[0].scrollIntoView(true);", employeeNameOption);
        return employeeNameOption;
    }

    public void clickOnTheAddButtonFromTheWrapper(String wrapperLabel) {
        this.waitMillis(SHORT_WAIT);
        By biPlusXpath = By.xpath("//*/label[contains(text(),'" + wrapperLabel + "')]/../../../div[2]//button/i");
        this.waitVisibilityOfElement(biPlusXpath, ELEMENT_VISIBILITY_DELAY);
        WebElement biPlusIcon = getDriver().findElement(biPlusXpath);
        biPlusIcon.click();
    }

    public void selectAllTheIncludeHeader(String headerLabel) {
        this.waitMillis(SHORT_WAIT);
        By checkBoxXpath = By.xpath("//*/div/p[text()='" + headerLabel + "']/../div/label");
        this.waitVisibilityOfElement(checkBoxXpath, ELEMENT_VISIBILITY_DELAY);
        WebElement inputCheckBox = getDriver().findElement(checkBoxXpath);
        inputCheckBox.click();
        if (inputCheckBox.isSelected()) {
            inputCheckBox.click();
        }
    }

    public void scrollHorizontalToTheElement(String elementLabel) {
        this.waitMillis(TIMEOUT + TIMEOUT);
        By elementXpath = By.xpath("//*/div//*[contains(text(),'" + elementLabel + "')]");
        this.getElementWithVerticalScrollBar("horizontal", elementXpath);
    }

    public WebElement getElementWithVerticalScrollBar(String scrollDirection, By xPath) {
        int scrolledPixels = 100;
        WebElement context = this.elementIsVisible(xPath, 2);
        while (context == null) {
            scrolledPixels = scrolledPixels + SCROLL_AMOUNT;
            this.scrollUp(scrollDirection, scrolledPixels, 0);
            context = this.elementIsVisible(xPath, 2);
            scrolledPixels = scrolledPixels + SCROLL_AMOUNT;
        }
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("return arguments[0].scrollHeight", context);
        return context;
    }

    public WebElement elementIsVisible(By locator, long timeOutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeOutInSeconds));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (NoSuchElementException | TimeoutException e) {
            System.out.println("Lotfi Otai");
        }
        return null;
    }

    public void scrollUp(String scrollDirection, int horizontalPosition, int verticalPosition) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElement scroll = this.findScrollbar(scrollDirection);
        js.executeScript("arguments[0].scrollTo(arguments[1], arguments[2]);", scroll, horizontalPosition, verticalPosition);
    }

    public WebElement findScrollbar(String scrollDirection) {
        return getDriver().findElement(By.xpath("//*/revogr-scroll-virtual[@class='" + scrollDirection + "']"));
    }

    public void scrollToTheLabel(String copyRightLabel) {
        this.waitMillis(SHORT_WAIT);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        By copyRightXpath = By.xpath("//*[text()='" + copyRightLabel + "']");
        WebElement copyRightXpathField = getDriver().findElement(copyRightXpath);
        js.executeScript("arguments[0].scrollIntoView(true);", copyRightXpathField);
        js.executeScript("window.scrollBy(0, -120)");
        this.waitMillis(SHORT_WAIT);
    }

    public void scrollScrollToTheBottomOfThePage() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void playWithTheVerticalAndHorizontalScrollBar() {
        this.waitMillis(SHORT_WAIT);
        this.scrollUp("vertical", 0, 1500);
        this.waitMillis(SHORT_WAIT);
        this.scrollUp("horizontal", 1500, 0);


        this.waitMillis(SHORT_WAIT);
        this.scrollUp("vertical", 0, 250);
        this.waitMillis(SHORT_WAIT);
        this.scrollUp("vertical", 0, 500);
        this.waitMillis(SHORT_WAIT);
        this.scrollUp("vertical", 0, 750);
        this.waitMillis(SHORT_WAIT);
        this.scrollUp("vertical", 0, 1000);
        this.waitMillis(SHORT_WAIT);
        this.scrollUp("vertical", 0, 0);


        this.waitMillis(SHORT_WAIT);
        this.scrollUp("horizontal", 250, 0);
        this.waitMillis(SHORT_WAIT);
        this.scrollUp("horizontal", 500, 0);
        this.waitMillis(SHORT_WAIT);
        this.scrollUp("horizontal", 750, 0);
        this.waitMillis(SHORT_WAIT);
        this.scrollUp("horizontal", 1000, 0);


        this.waitMillis(SHORT_WAIT);
        this.scrollUp("horizontal", 0, 0);
        this.waitMillis(SHORT_WAIT);
        this.scrollUp("vertical", 0, 1000);
        this.waitMillis(SHORT_WAIT);
        this.scrollUp("horizontal", 0, 0);
        this.waitMillis(SHORT_WAIT);
        this.scrollUp("vertical", 1000, 0);


        this.waitMillis(SHORT_WAIT);
        this.scrollUp("horizontal", 1000, 0);
        this.waitMillis(SHORT_WAIT);
        this.scrollUp("vertical", 0, 250);
        this.waitMillis(SHORT_WAIT);
        this.scrollUp("horizontal", 250, 0);
        this.waitMillis(SHORT_WAIT);
        this.scrollUp("vertical", 0, 500);
        this.waitMillis(SHORT_WAIT);
        this.scrollUp("horizontal", 500, 0);
        this.waitMillis(SHORT_WAIT);
        this.scrollUp("vertical", 0, 750);
        this.waitMillis(SHORT_WAIT);
        this.scrollUp("horizontal", 750, 0);

        this.waitMillis(SHORT_WAIT);
        this.scrollUp("vertical", 0, 0);
        this.waitMillis(SHORT_WAIT);
        this.scrollUp("horizontal", 0, 0);
        this.waitMillis(SHORT_WAIT);
        this.scrollUp("vertical", 0, 1200);
        this.waitMillis(SHORT_WAIT);
        this.scrollUp("horizontal", 1500, 0);
        this.waitMillis(SHORT_WAIT);
        this.scrollUp("vertical", 0, 500);
        this.waitMillis(SHORT_WAIT);
        this.scrollUp("horizontal", 750, 0);
        this.waitMillis(SHORT_WAIT);
        this.scrollUp("vertical", 0, 1200);
        this.waitMillis(SHORT_WAIT);
        this.scrollUp("horizontal", 1500, 0);
        this.waitMillis(SHORT_WAIT);
        this.scrollUp("vertical", 0, 0);
        this.waitMillis(SHORT_WAIT);
        this.scrollUp("horizontal", 1500, 0);
    }
}