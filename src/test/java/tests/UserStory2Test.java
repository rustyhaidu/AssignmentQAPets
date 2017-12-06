package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class UserStory2Test extends BaseTest {

    private HomePage homePage;

    @BeforeMethod
    public void userStory1BeforeMethod() {
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test
    public void listOfPetsHeaderTest() {
        String sExpectedColumn1 = "Name";
        String sExpectedColumn2 = "Status";
        String sExpectedColumn3 = "Action";

        String sActualColumn1 = homePage.getTableHeader(1).getText();
        String sActualColumn2 = homePage.getTableHeader(2).getText();
        String sActualColumn3 = homePage.getTableHeader(3).getText();

        Assert.assertEquals(sActualColumn1, sExpectedColumn1, "Checking Name Column in Header");
        Assert.assertEquals(sActualColumn2, sExpectedColumn2, "Checking Name Column in Header");
        Assert.assertEquals(sActualColumn3, sExpectedColumn3, "Checking Name Column in Header");
    }

    @Test
    public void insert100PetsTest() throws InterruptedException {

        int rowCount = homePage.getVisibleTableRowCount();

        if (rowCount > 0) {
            for (int i = 0; i < rowCount; i++) {
               Thread.sleep(100);
                clickElement(homePage.getVisibleDelete());
               // homePage.getVisibleDelete().click();
            }
        }

        for (int i = 0; i < 100; i++) {
            homePage.getPetNameEdit().sendKeys("Pet" + i);
            homePage.getPetStatusEdit().sendKeys("Status" + i);
            clickElement(homePage.getVisibleCreate());
        }

        Thread.sleep(100);
        rowCount = homePage.getVisibleTableRowCount();

        Assert.assertEquals(rowCount, 100);
    }

    @Test
    public void petListCountTest() {
        System.out.println(homePage.getTableRowCount());
        System.out.println(homePage.getVisibleTableRowCount());
    }

    @Test
    public void singleDelete(){

        WebElement petName = driver.findElement(By.xpath("//*[contains(text(), 'Delete')]"));
        clickElement(petName);
    }
}
