package it.otai.e2e.pages;

import it.otai.e2e.configurations.OtaiE2EProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class AdminPage extends BasePage {
    private final OtaiE2EProperties otaiE2EProperties;
    By iconXpath = By.xpath("//div[@class='org-action']/button[1]");
    protected AdminPage(OtaiE2EProperties otaiE2EProperties) {
        super(otaiE2EProperties);
        this.otaiE2EProperties = otaiE2EProperties;
    }

    public void clickOnButton(String label) {
        By buttonXpath = By.xpath("//*[text()='" + label + "']/span");
        this.waitVisibilityOfElement(buttonXpath, ELEMENT_VISIBILITY_DELAY);
        WebElement buttonField = getDriver().findElement(buttonXpath);
        buttonField.click();
    }

    public void deleteTheTreeNodeContent() {
        List<WebElement> iconButtons = this.gettingIconButtons();
        while (!iconButtons.isEmpty()) {
            WebElement iconButton = iconButtons.get(0);
            this.waitMillis(TIMEOUT);
            iconButton.click();
            this.clickOn(" Yes, Delete ");
            int initialCount = iconButtons.size();
            if (initialCount > 1) {
                this.waitForElementCountToDecrease(iconXpath, initialCount, ELEMENT_VISIBILITY_DELAY);
            }
            if (iconButtons == null || iconButtons.isEmpty()) {
                break;
            } else {
                iconButtons = this.gettingIconButtons();
            }
        }
    }

    public List<WebElement> gettingIconButtons() {
        this.waitMillis(TIMEOUT);
        if (isElementPresent(iconXpath)) {
            this.waitVisibilityOfElement(iconXpath, ELEMENT_VISIBILITY_DELAY);
            return getDriver().findElements(iconXpath);
        }
        return Collections.emptyList();
    }

    public void fillTheUnitField(String label, String value) {
        By unitFieldXpath = By.xpath("//*[text()='" + label + "']/../..//input");
        this.waitVisibilityOfElement(unitFieldXpath, ELEMENT_VISIBILITY_DELAY);
        WebElement unitField = getDriver().findElement(unitFieldXpath);
        unitField.sendKeys(value);
    }

    public String getFormattedValue(String defaultValue) {
        return switch (defaultValue) {
            case "phoneNumber" -> otaiE2EProperties.getPhoneNumber();
            case "emailAddress" -> otaiE2EProperties.getEmailAddress();
            case "GitHub Url" -> otaiE2EProperties.getGitHubUrl();
            case "Linkedin Url" -> otaiE2EProperties.getLinkedinUrl();
            default -> defaultValue;
        };
    }

    public void clickOnAddButtonFromTheNode(String nodeLabel) {
        this.waitMillis(TIMEOUT);
        By nodeLabelXpath = By.xpath("//div[contains(text(), '" + nodeLabel + "')]/..//div[@class='org-action']/button[3]");
        this.waitVisibilityOfElement(nodeLabelXpath, ELEMENT_VISIBILITY_DELAY);
        WebElement nodeLabelField = getDriver().findElement(nodeLabelXpath);
        nodeLabelField.click();
    }

    public void clickOnTheToggleNodeFrom(String toggleNode) {
        this.waitMillis(TIMEOUT);
        By toggleNodeXpath = By.xpath("//*[contains(text(),'" + toggleNode + "')]/../../preceding-sibling::span");
        this.waitVisibilityOfElement(toggleNodeXpath, ELEMENT_VISIBILITY_DELAY);
        WebElement toggleNodeField = getDriver().findElement(toggleNodeXpath);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(false);", toggleNodeField);
        toggleNodeField.click();
    }

    public WebElement scrollToFind(String itemLabel) {
        waitMillis(TIMEOUT);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        By itemLabelXpath = By.xpath("//*[text()='" + itemLabel + "']");
        this.waitVisibilityOfElement(itemLabelXpath, ELEMENT_VISIBILITY_DELAY);
        WebElement itemField = getDriver().findElement(itemLabelXpath);
        js.executeScript("arguments[0].scrollIntoView(false);", itemField);
        return itemField;
    }
}
