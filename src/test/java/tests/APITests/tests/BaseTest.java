package tests.APITests.tests;

import org.testng.annotations.BeforeMethod;
import tests.APITests.models.Pet;
import tests.APITests.services.ApiOperations;

import java.util.List;

public abstract class BaseTest {
    ApiOperations apiOperations;
    private List<Pet> petList;

    @BeforeMethod
    public void setUp() {
        apiOperations = new ApiOperations();
        petList = apiOperations.getPetList();

        for (Pet pet : petList) {
            apiOperations.deletePetById(pet.getId());
        }
    }


      /*@AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }*/
}
