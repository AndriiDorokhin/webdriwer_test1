package controller;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DriverProvider {
    private static DriverProvider INSTANCE = null;
    private WebDriver driver = null;

    private DriverProvider() {}

    private DriverProvider(String driverType) throws IOException {
        if (driverType.equalsIgnoreCase("mozilla")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else if (driverType.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().version("2.46").setup();
            driver = new ChromeDriver();
        }else if (driverType.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
        }
    }

    public static DriverProvider get(String driverType) {
        if(INSTANCE == null){
            try {
                INSTANCE = new DriverProvider(driverType);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return INSTANCE;
    }

    public WebDriver getWebDriver() {
        return driver;
    }
}