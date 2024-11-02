package it.otai.e2e.stepDefinitions;

import io.cucumber.java.en.Then;
import it.otai.e2e.pages.DashboardEmployeeDistributionPage;

public class DashboardEmployeeDistributionStepDefinitions {
    private final DashboardEmployeeDistributionPage dashboardEmployeeDistributionPage;
    public DashboardEmployeeDistributionStepDefinitions(DashboardEmployeeDistributionPage dashboardEmployeeDistributionPage) {
        this.dashboardEmployeeDistributionPage = dashboardEmployeeDistributionPage;
    }

    @Then("I click on the legend key {string}")
    public void iClickOnTheLegendKey(String legendKeyLabel) {
        dashboardEmployeeDistributionPage.clickOnTheLegendKey(legendKeyLabel);
    }

    @Then("I click on the second legend key {string}")
    public void iClickOnTheSecondLegendKey(String secondLegendKeyLabel) {
        dashboardEmployeeDistributionPage.clickOnTheSecondLegendKey(secondLegendKeyLabel);
    }

    @Then("I scroll the Dashboard page")
    public void iScrollTheDashboardPage() throws InterruptedException {
        dashboardEmployeeDistributionPage.scrollThePage();
    }
}
