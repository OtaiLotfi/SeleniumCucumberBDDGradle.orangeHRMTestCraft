package it.otai.e2e.stepDefinitions;

import io.cucumber.java.en.Given;
import it.otai.e2e.configurations.OtaiUserCredentials;
import it.otai.e2e.pages.NavigationPage;

public class NavigationStepDefinitions {

  private final NavigationPage navigation;

  public NavigationStepDefinitions(NavigationPage navigation) {
    this.navigation = navigation;
  }

  @Given("I open ebay with user {otaiUser} and password {otaiPassword}")
  public void iOpenAppWithUser(OtaiUserCredentials.OtaiUser otaiUser, OtaiUserCredentials.OtaiPassword otaiPassword) {
    navigation.doLoginWithUser(otaiUser, otaiPassword);
  }
}
