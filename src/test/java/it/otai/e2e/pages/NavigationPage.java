package it.otai.e2e.pages;

import it.otai.e2e.configurations.OtaiE2EProperties;
import it.otai.e2e.configurations.OtaiUserCredentials;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class NavigationPage extends BasePage {

  private static final By LOGIN_USERNAME = By.xpath("//*/div[@class='oxd-form-row']/div/div[2]/input[@name='username']");
  private static final By LOGIN_PASSWORD = By.xpath("//*/div[@class='oxd-form-row']/div/div[2]/input[@name='password']");
  private static final By LOGIN_BUTTON = By.xpath("//*/div/button[@type='submit']");

private final OtaiE2EProperties otaiE2EProperties;
  protected NavigationPage(OtaiE2EProperties otaiE2EProperties) {
      super(otaiE2EProperties);
      this.otaiE2EProperties = otaiE2EProperties;
  }

  public void doLoginWithUser(OtaiUserCredentials.OtaiUser ebayUser, OtaiUserCredentials.OtaiPassword ebayPassword) {
    var driver = getDriver();
    getDriver().get(otaiE2EProperties.getOrangeHRMUrl());
    this.waitMillis(TIMEOUT);
    driver.findElement(LOGIN_USERNAME).sendKeys(this.getUsersProperties().getUsername(ebayUser));
    driver.findElement(LOGIN_PASSWORD).sendKeys(this.getUsersProperties().getPassword(ebayPassword));
    driver.findElement(LOGIN_BUTTON).click();
  }

}
