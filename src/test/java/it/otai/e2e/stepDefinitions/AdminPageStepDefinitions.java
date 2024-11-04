package it.otai.e2e.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import it.otai.e2e.pages.AdminPage;
import it.otai.e2e.pages.OrangeHRMPage;

public class AdminPageStepDefinitions {
    private final AdminPage adminPage;
    private final OrangeHRMPage orangeHRMPage;
    public AdminPageStepDefinitions(AdminPage adminPage, OrangeHRMPage orangeHRMPage) {
        this.adminPage = adminPage;
        this.orangeHRMPage = orangeHRMPage;
    }

    @And("I click on {string} Button")
    public void iClickOnButton(String label) {
        adminPage.clickOnButton(label);
    }

    @Then("I delete the tree node content")
    public void iDeleteTheTreeNodeContent() {
        adminPage.deleteTheTreeNodeContent();
    }

    @Then("I fill the {string} with {string}")
    public void iFillTheWith(String label, String value) {
        String rightValue = adminPage.getFormattedValue(value);
        adminPage.fillTheUnitField(label, rightValue);
    }

    @Then("I click on add button from the node {string}")
    public void iClickOnAddButtonFromTheNode(String nodeLabel) {
        adminPage.clickOnAddButtonFromTheNode(nodeLabel);
    }

    @And("I click on the toggle node from {string}")
    public void iClickOnTheToggleNodeFrom(String toggleNode) {
        adminPage.clickOnTheToggleNodeFrom(toggleNode);
    }

    @Then("I scroll to find {string}")
    public void iScrollToFind(String itemLabel) {
        adminPage.scrollToFind(itemLabel);
    }

    @Then("I scroll to the top of the page")
    public void iScrollToTheTopOfThePage() throws InterruptedException {
        adminPage.scrollToTheTopOfThePage();
    }
}
