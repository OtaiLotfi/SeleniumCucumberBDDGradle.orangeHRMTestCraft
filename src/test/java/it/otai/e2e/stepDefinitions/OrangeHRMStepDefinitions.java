package it.otai.e2e.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import it.otai.e2e.pages.OrangeHRMPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import static it.otai.e2e.common.CucumberHelper.getDriver;

public class OrangeHRMStepDefinitions {
    private final OrangeHRMPage orangeHRMPage;
    private final By parentRowGroupXpath = By.xpath("/*//div[@class='oxd-table-body']");

    public OrangeHRMStepDefinitions(OrangeHRMPage orangeHRMPage) {
        this.orangeHRMPage = orangeHRMPage;
    }

    @Then("I open {string} from the menu")
    public void iOpenFromTheMenu(String itemLabel) {
        orangeHRMPage.openFromTheMenu(itemLabel);
    }

    @And("I click on {string}")
    public void iClickOn(String buttonLabel) {
        orangeHRMPage.clickOn(buttonLabel);
    }

    @Then("I delete records")
    public void iDeleteRecords() {
        orangeHRMPage.deleteRecords(parentRowGroupXpath);
    }

    @And("I click on {string} from the top bar")
    public void iClickOnFromTheTopBar(String topBarItem) {
        orangeHRMPage.clickOnFromTheTopBar(topBarItem);
    }

    @Then("I select all records on the left based on {string}")
    public void iSelectAllRecordsOnTheLeftBasedOn(String columnHeaderName) {
        orangeHRMPage.selectAllRecordsOnTheLeftBasedOn(columnHeaderName);
    }

    @Then("I enter the {string} for {string}")
    public void iEnterTheFor(String reportName, String nameValue) {
        orangeHRMPage.enterTheFor(reportName, nameValue);
    }

    @And("I select the wrapper {string} for {string}")
    public void iSelectTheWrapperFor(String wrapperLabel, String inputValue) {
        orangeHRMPage.selectTheWrapperFor(wrapperLabel, inputValue);
    }

    @And("I click on the add button from the wrapper {string}")
    public void iClickOnTheAddButtonFromTheWrapper(String wrapperLabel) {
        orangeHRMPage.clickOnTheAddButtonFromTheWrapper(wrapperLabel);
    }

    @And("I select all the {string}")
    public void iSelectAllThe(String headerLabel) {
        orangeHRMPage.selectAllTheIncludeHeader(headerLabel);
    }

    @Then("I scroll horizontal to the element {string}")
    public void iScrollHorizontalToTheElement(String elementLabel) {
        orangeHRMPage.scrollHorizontalToTheElement(elementLabel);
    }

    @Then("I play with the vertical and horizontal scroll bar")
    public void iPlayWithTheVerticalAndHorizontalScrollBar() {
        orangeHRMPage.playWithTheVerticalAndHorizontalScrollBar();
    }

    @And("I scroll to the label {string}")
    public void iScrollToTheLabel(String copyRightLabel) {
        orangeHRMPage.scrollToTheLabel(copyRightLabel);
    }

    @And("I scroll Scroll to the bottom of the page")
    public void iScrollScrollToTheBottomOfThePage() {
        orangeHRMPage.scrollScrollToTheBottomOfThePage();
    }

    @And("I click on a white space")
    public void iClickOnAWhiteSpace() {
        Actions action = new Actions(getDriver());
        action.sendKeys(Keys.ESCAPE).perform();
    }
}