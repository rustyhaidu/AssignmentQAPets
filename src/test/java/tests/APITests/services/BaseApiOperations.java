package tests.APITests.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import tests.APITests.models.ApiResponse;
import tests.APITests.models.Pet;

import java.io.IOException;
import java.io.InputStream;

public class BaseApiOperations {

    ApiResponse getApiResponse(String URLRequest) throws IOException {

        CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(URLRequest);
        HttpResponse httpResponse = httpclient.execute(httpGet);

        int statusCode = httpResponse.getStatusLine().getStatusCode();

        InputStream bodyAsInputStream = httpResponse.getEntity().getContent();
        String jsonContent = IOUtils.toString(bodyAsInputStream);
        httpclient.close();
        return new ApiResponse(statusCode, jsonContent);
    }

    Pet getPetModel(String jsonData) {
        if (!jsonData.equals("")) {
            Pet pet = null;
            ObjectMapper om = new ObjectMapper();
            try {
                pet = om.readValue(jsonData, Pet.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return pet;
        }
        return null;
    }
}
