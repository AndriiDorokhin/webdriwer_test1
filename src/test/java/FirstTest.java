import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ResultPage;

public class FirstTest extends BaseTest{
    private final String searchingText = " Facebook ";
    private final String basePageUrl = "https://www.google.com";
    private final String searchingUrl = "https://uk-ua.facebook.com/";


    @Test
    public void verifyTitleContainsWord() throws InterruptedException {
        ResultPage resultPage = googlePage.navigateTo(basePageUrl).showResults(searchingText);
        String curentUrl = resultPage.openFacebookPageLink().getCurentUrl();
        System.out.println("=================================");
        System.out.println(curentUrl);
        System.out.println("=================================");

        Allure.addAttachment("check of Header","Header contains '" + searchingUrl + "'");

        Assert.assertTrue(searchingUrl.toLowerCase().contains(searchingUrl),"Current URL is -> '" + searchingUrl +"'");
    }
}
