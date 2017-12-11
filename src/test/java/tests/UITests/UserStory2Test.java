package tests.UITests;


import org.testng.Assert;
import org.testng.annotations.Test;

public class UserStory2Test extends BaseUserStoryTest {

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


        for (int i = 0; i < 100; i++) {
            homePage.getPetNameEdit().sendKeys("Pet" + i);
            homePage.getPetStatusEdit().sendKeys("Status" + i);
            clickElement(homePage.getVisibleCreate());
        }

        Thread.sleep(300);
        int rowCount = homePage.getVisibleTableRowCount();

        Assert.assertEquals(rowCount, 100);
    }

    /*@Test
    public void petListCountTest() {
        System.out.println(homePage.getTableRowCount());
        System.out.println(homePage.getVisibleTableRowCount());
    }

    @Test
    public void singleDelete(){

        WebElement petName = driver.findElement(By.xpath("//*[contains(text(), 'Delete')]"));
        clickElement(petName);
    }*/
}
