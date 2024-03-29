package pageObjects;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;

public class ResultPage extends BasePage {
    private final By links = By.xpath("//h3");
    private final By nextPageResultButton = By.id("pnnext");
    private final By facebookPageLink = By.xpath("//div[@class='ellip' and contains(text(),'Facebook — увійдіть або зареєструйтеся')]");

    public FacebookPage openFirstPage() {
        driver.findElements(links).get(0).click();
        Allure.addAttachment("ResultPage click first link", "First link was clicked");

        return new FacebookPage();
    }

    public FacebookPage openFacebookPageLink() {
        driver.findElements(links).get(0).click();
        Allure.addAttachment("ResultPage click first link", "First link was clicked");

        return new FacebookPage();
    }

    public ResultPage showNextResultPage() {
        driver.findElement(nextPageResultButton).click();
        Allure.addAttachment("ResultPage click next page button", "next result page was clicked");

        return this;
    }

    public boolean isExpectDomainOnSearchingResult(String expectedDomain, int numberOfResultPage) throws InterruptedException {
        boolean isExpectDomain = false;

        for (int i = 1; i < numberOfResultPage; i++) {
            if (driver.getPageSource().contains(expectedDomain)) {
                isExpectDomain = true;
                break;
            }else {
                showNextResultPage();
            }
        }

        if (isExpectDomain){
            Allure.addAttachment("ResultPage is Expect Domain On Searching Result", "Expect Domain is On Result");
        }else {
            Allure.addAttachment("ResultPage is Expect Domain On Searching Result", "Expect Domain is NOT On Result");
        }

        return isExpectDomain;
    }
}
