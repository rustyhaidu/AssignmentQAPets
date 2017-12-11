package tests.APITests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.APITests.models.Pet;

public class DeletePetTests extends BaseTest{

    @Test
    public void deletePetTest() {
        Pet pet = new Pet("Test", "active");
        apiOperations.addPet(pet);
        int statusCode = apiOperations.deletePetById(1);

        Assert.assertEquals(200, statusCode, "Testing that the pet was deleted");
    }
}
