import controller.DriverProvider;
import org.testng.annotations.AfterSuite;
import pageObjects.GooglePage;

public class BaseTest {
    private DriverProvider driverProvider = DriverProvider.get("mozilla");
    protected GooglePage googlePage = new GooglePage();


    @AfterSuite
    public void closebrowser() throws InterruptedException {
        try {
            if(driverProvider.getWebDriver() != null)
                driverProvider.getWebDriver().quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
