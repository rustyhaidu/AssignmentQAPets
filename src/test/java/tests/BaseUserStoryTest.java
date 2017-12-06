package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

public class BaseUserStoryTest extends BaseTest{

    HomePage homePage;

    @BeforeMethod
    public void userStory1BeforeMethod() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        deleteAllPets();
    }

    public void deleteAllPets(){
        int rowCount = homePage.getVisibleTableRowCount();

        if (rowCount > 0) {
            for (int i = 0; i < rowCount; i++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                clickElement(homePage.getFirstVisibleDelete());
                // homePage.getFirstVisibleDelete().click();
            }
        }
    }
}
