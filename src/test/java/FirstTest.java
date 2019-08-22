import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ResultPage;

public class FirstTest extends BaseTest{
    private final String searchingText = " Facebook ";
    private final String basePageUrl = "https://www.google.com";
    private final String searchingUrl = "https://www.facebook.com";


    @Test
    public void verifyTitleContainsWord() throws InterruptedException {
        ResultPage resultPage = googlePage.navigateTo(basePageUrl).showResults(searchingText);
        String title = resultPage.openFacebookPageLink().getCurentUrl();
        Allure.addAttachment("check of Header","Header contains '" + searchingUrl + "'");

        Assert.assertTrue(title.toLowerCase().contains(searchingText),"Header contains '" + searchingText +"'");
    }
}
