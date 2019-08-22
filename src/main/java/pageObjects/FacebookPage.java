package pageObjects;

public class FacebookPage extends BasePage {
    public String getTitle() {
        return driver.getTitle();
    }

    public String getCurentUrl() {
        return driver.getCurrentUrl();
    }
}
