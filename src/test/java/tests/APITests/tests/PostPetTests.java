package tests.APITests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.APITests.models.Pet;


public class PostPetTests extends BaseTest {

    @Test
    public void addSinglePetStatusCodeTest() {
        Pet pet = new Pet("Test", "active");
        int statusCode = apiOperations.addPet(pet);

        Assert.assertEquals(201, statusCode, "Testing that the pet was added");
    }

    @Test
    public void addMultiplePetStatusCodeTest() {

        for (int i = 1; i <= 10; i++) {
            Pet pet = new Pet(i, "Test"+i, "active"+i);
            int statusCode = apiOperations.addPet(pet);
            Assert.assertEquals(201, statusCode, "Testing that the pet was added");
        }
    }

    @Test
    public void updatePetStatusCodeTest() {
        Pet pet = new Pet("Test", "active");
        apiOperations.addPet(pet);

        Pet updatedPet = new Pet(1, "UpdatedTest", "updatedStatus");
        apiOperations.updatePet(1, updatedPet);

        Pet retrievedPet = apiOperations.getPetById(1);
        Assert.assertEquals(retrievedPet, updatedPet, "Testing that the pet was updated");
    }
}
