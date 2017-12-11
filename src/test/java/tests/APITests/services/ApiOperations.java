package tests.APITests.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import tests.APITests.models.Pet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static tests.APITests.constants.Constants.*;

public class ApiOperations extends BaseApiOperations {

    public Pet getPetById(int id) {
        String jsonData = "";
        try {
            jsonData = getApiResponse(PET_PETS_URL + id).getJsonContent();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getPetModel(jsonData);
    }

    public List<Pet> getPetList() {
        List<Pet> petList = new ArrayList<>();

        String jsonData;

        try {
            jsonData = getApiResponse(PET_PETS_URL).getJsonContent();

            ObjectMapper objectMapper = new ObjectMapper();
            petList = objectMapper.readValue(jsonData, new TypeReference<List<Pet>>() {
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        return petList;
    }

    public int deletePetById(int id) {
        int statusCode = 0;
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpDelete deleteRequest = new HttpDelete(PET_PETS_URL + id);

        HttpResponse response;
        try {
            response = httpClient.execute(deleteRequest);
            statusCode = response.getStatusLine().getStatusCode();
            httpClient.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
        return statusCode;

    }

    public int addPet(Pet pet) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost postRequest = new HttpPost(
                PET_PETS_URL);

        StringEntity input;
        ObjectMapper mapper = new ObjectMapper();

        int statusCode = 0;
        try {
            //input = new StringEntity(pet.toString());
            input = new StringEntity(mapper.writeValueAsString(pet));
            input.setContentType(APPLICATION_JSON);
            postRequest.setEntity(input);

            HttpResponse response = httpClient.execute(postRequest);
            statusCode = response.getStatusLine().getStatusCode();

            httpClient.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return statusCode;
    }

    public int updatePet(int id, Pet pet) {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPut putRequest = new HttpPut(PET_PETS_URL + pet.getId());

        ObjectMapper mapper = new ObjectMapper();

        StringEntity input;
        int statusCode = 0;
        try {
            input = new StringEntity(mapper.writeValueAsString(pet));
            input.setContentType(APPLICATION_JSON);
            putRequest.setEntity(input);

            HttpResponse response = httpClient.execute(putRequest);
            statusCode = response.getStatusLine().getStatusCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return statusCode;
    }
}
