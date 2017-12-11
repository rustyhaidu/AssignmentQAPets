package pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    static WebDriver driver;

    public void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }
}
