package pageObjects;

import controller.DriverProvider;
import org.openqa.selenium.WebDriver;


public class BasePage {
    protected WebDriver driver = DriverProvider.get("mozilla").getWebDriver();

    public BasePage navigateTo(String stringUrl) {
        driver.get(stringUrl);

        return this;
    }
}
