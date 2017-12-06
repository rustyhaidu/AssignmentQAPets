package tests;

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
        WebElement focus = driver.switchTo().activeElement();
        String placeholder = focus.getAttribute("class");
        String placeholder2 = focus.getAttribute("value");
        String placeholder3 = focus.getAttribute("placeholder");

        System.out.println(placeholder3);
        System.out.println(placeholder2);
        Assert.assertEquals("pet usr-input pet-status", placeholder);


    }

    @Test
    public void pressingEnterTest() {

    }


}
