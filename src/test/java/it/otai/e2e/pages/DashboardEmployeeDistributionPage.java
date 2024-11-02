package it.otai.e2e.pages;

import it.otai.e2e.configurations.OtaiE2EProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class DashboardEmployeeDistributionPage extends BasePage{
    private final OtaiE2EProperties otaiE2EProperties;

    protected DashboardEmployeeDistributionPage(OtaiE2EProperties otaiE2EProperties) {
        super(otaiE2EProperties);
        this.otaiE2EProperties = otaiE2EProperties;
    }

    public void clickOnTheLegendKey(String legendKeyLabel) {
        By legendKeyLabelXpath = By.xpath("//*/span[text()='" + legendKeyLabel + "']");
        this.waitVisibilityOfElement(legendKeyLabelXpath, ELEMENT_VISIBILITY_DELAY);
        WebElement legendKeyLabelField = getDriver().findElement(legendKeyLabelXpath);
        legendKeyLabelField.click();
        this.waitMillis(SHORT_WAIT);
    }

    public void clickOnTheSecondLegendKey(String legendKeyLabel) {
        By legendKeyLabelXpath = By.xpath("(//*/span[text()='" + legendKeyLabel + "'])[2]");
        this.waitVisibilityOfElement(legendKeyLabelXpath, ELEMENT_VISIBILITY_DELAY);
        WebElement legendKeyLabelField = getDriver().findElement(legendKeyLabelXpath);
        legendKeyLabelField.click();
        this.waitMillis(SHORT_WAIT);
    }
}
