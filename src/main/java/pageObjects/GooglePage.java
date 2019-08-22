package pageObjects;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;

public class GooglePage extends BasePage {
    private final By textbox = By.name("q");

    public ResultPage showResults(String searchingText) {
        driver.findElement(textbox).sendKeys(searchingText);
        driver.findElement(textbox).submit();

        System.out.println("word '"+searchingText+"' Entered in Textbox and Submited");
        Allure.addAttachment("GooglePage "+searchingText+"", "word "+ searchingText + " Entered in Textbox and Submited");

        return new ResultPage();
    }

    public GooglePage navigateTo(String stringUrl) {
        super.navigateTo(stringUrl);

        return this;
    }
}
