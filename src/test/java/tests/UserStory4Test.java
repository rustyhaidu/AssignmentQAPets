package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserStory4Test extends BaseUserStoryTest {

    @BeforeMethod
    public void setupUS4() {
        homePage.getPetNameEdit().sendKeys("PetEdit");
        homePage.getPetStatusEdit().sendKeys("Editable");
        clickElement(homePage.getVisibleCreate());
    }

    @Test
    public void editPetTest() throws InterruptedException {

        clickElement(homePage.getFirstVisibleNameSpan());
        clickElement(homePage.getFirstVisibleNameInput());
        homePage.getFirstVisibleNameInput().clear();
        homePage.getFirstVisibleNameInput().sendKeys("EditedName");

        homePage.getFirstVisibleStatusInput().clear();
        clickElement(homePage.getFirstVisibleStatusSpan());
        clickElement(homePage.getFirstVisibleStatusInput());
        homePage.getFirstVisibleStatusInput().clear();
        homePage.getFirstVisibleStatusInput().sendKeys("EditedStatus");

        homePage.getPetNameEdit().click();

        String editedName = homePage.getFirstVisibleNameSpan().getText();

        Assert.assertEquals("EditedName", editedName);

        String editedStatus = homePage.getFirstVisibleStatusSpan().getText();
        Assert.assertEquals("EditedStatus", editedStatus);
    }

    @Test
    public void pressingEscTest() throws InterruptedException {
        clickElement(homePage.getFirstVisibleNameSpan());
        Thread.sleep(1000);
        clickElement(homePage.getFirstVisibleNameInput());

        homePage.getFirstVisibleNameInput().clear();
        homePage.getFirstVisibleNameInput().sendKeys("PetName");
        WebElement focus = driver.switchTo().activeElement();
        String className = focus.getAttribute("class");
        String petName = focus.getAttribute("value");

        Assert.assertEquals("pet usr-input pet-name", className);
        Assert.assertEquals("PetName", petName);

        homePage.getFirstVisibleNameInput().sendKeys(Keys.ESCAPE);
        focus = driver.switchTo().activeElement();
        className = focus.getAttribute("class");
        petName = focus.getAttribute("value");

        Assert.assertNotEquals("pet usr-input pet-name", className);
        Assert.assertNotEquals("PetName", petName);

    }

    @Test
    public void pressingEnterTest() throws InterruptedException {
        clickElement(homePage.getFirstVisibleNameSpan());
        Thread.sleep(1000);
        clickElement(homePage.getFirstVisibleNameInput());

        homePage.getFirstVisibleNameInput().clear();
        homePage.getFirstVisibleNameInput().sendKeys("PetNameSaved");

        homePage.getFirstVisibleNameInput().sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        String petName = homePage.getTableData(1,1).getText();

        Assert.assertEquals("PetNameSaved", petName);

    }


}
