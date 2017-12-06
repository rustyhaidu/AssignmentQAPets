package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {

    public static WebDriver driver;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
