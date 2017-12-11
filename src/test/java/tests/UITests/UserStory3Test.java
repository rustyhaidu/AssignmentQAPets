package tests.UITests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserStory3Test extends BaseUserStoryTest {


    @Test
    public void mandatoryFieldsTest() {

        homePage.clickAndClearPetNameField();
        homePage.sendKeysNameField("");

        homePage.clickAndClearPetStatusField();
        homePage.clickCreateButton();

        int lastRow = homePage.getPetTableRowCount();
        String addedPetName = homePage.getPetName(lastRow);
        String addedPetStatus = homePage.getPetStatus(lastRow);

        Assert.assertEquals(addedPetName.isEmpty(), false,
                "check if pet without Name was added");

        Assert.assertEquals(addedPetStatus.isEmpty(), false,
                "check if pet without Status was added");
    }

    @Test
    public void createPetUsingCreateButtonTest() throws InterruptedException {

        String petName = "Lorna";
        String petStatus = "Available";
        homePage.clickAndClearPetNameField();
        homePage.sendKeysNameField(petName);

        homePage.clickAndClearPetNameField();
        homePage.sendKeysStatusField(petStatus);

        homePage.clickCreateButton();
        Thread.sleep(300);
        int lastRow = homePage.getPetTableRowCount();
        String addedPetName = homePage.getPetName(lastRow);
        String addedPetStatus = homePage.getPetStatus(lastRow);

        Assert.assertEquals(addedPetName, petName, "check pet name was added");
        Assert.assertEquals(addedPetStatus, petStatus, "check pet status was added");
    }

    @Test
    public void createPetUsingEnterKeyTest() {

        String petName = "Lorna2";
        String petStatus = "Available";
        homePage.clickAndClearPetNameField();
        homePage.sendKeysNameField(petName);

        homePage.clickAndClearPetNameField();
        homePage.sendKeysStatusField(petStatus);

        homePage.getCreateButton().sendKeys(Keys.ENTER);

        int lastRow = homePage.getPetTableRowCount();
        String addedPetName = homePage.getPetName(lastRow);
        String addedPetStatus = homePage.getPetStatus(lastRow);

        Assert.assertEquals(addedPetName, petName, "check pet name was added");
        Assert.assertEquals(addedPetStatus, petStatus, "check pet status was added");
    }

    @Test
    public void tabKeyOnNameAndStatusTest() {

        homePage.clickPetNameField();
        homePage.getPetNameField().sendKeys(Keys.TAB);

        WebElement focus = driver.switchTo().activeElement();
        String placeholder = focus.getAttribute("placeholder");
        Assert.assertEquals("Pet Status", placeholder);
    }

    @Test
    public void shiftPlusTabKeysTest() throws InterruptedException {

        homePage.clickPetStatusField();
        homePage.getPetStatusField().sendKeys(Keys.SHIFT, Keys.TAB);

        WebElement focus = driver.switchTo().activeElement();
        String placeholder = focus.getAttribute("placeholder");
        Assert.assertEquals("Pet Name", placeholder);

    }

}
