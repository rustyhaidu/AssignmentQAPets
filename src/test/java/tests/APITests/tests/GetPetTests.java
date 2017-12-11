package tests.APITests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.APITests.models.Pet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GetPetTests extends BaseTest {

    @Test
    public void getPetByIdTest() {
        Pet pet = new Pet(1, "Test", "active");
        apiOperations.addPet(pet);
        Pet petFromApi = apiOperations.getPetById(1);

        Assert.assertEquals(pet, petFromApi, "Testing that the pet was retrieved");
    }

    @Test
    public void getListOfPets() {
        List<Pet> listOfPets = new ArrayList<>();
        List<Pet> listOfPetsFromApi = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            Pet pet = new Pet(i, "Test" + i, "active" + i);
            apiOperations.addPet(pet);
            listOfPets.add(pet);
        }

        listOfPetsFromApi = apiOperations.getPetList();

        Assert.assertEquals(listOfPets, listOfPetsFromApi, "Testing that the pet was retrieved");
    }

    @Test
    public void getRandomPetTest() {
        List<Pet> listOfPets = new ArrayList<>();


        for (int i = 1; i <= 10; i++) {
            Pet pet = new Pet(i, "Test" + i, "active" + i);
            apiOperations.addPet(pet);
            listOfPets.add(pet);
        }

        Random rand = new Random();
        int randomIndex = rand.nextInt(9) + 1;

        Pet randomPet = listOfPets.get(randomIndex - 1);
        Pet randomPetFromApi = apiOperations.getPetById(randomIndex);

        Assert.assertEquals(randomPetFromApi, randomPet, "Testing that the pet exists in the list of Pets");
    }
}
