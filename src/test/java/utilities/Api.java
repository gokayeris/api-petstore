package utilities;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Api {

    public static Response response;

    private static final String BASE_URI = ConfigReader.getProperty("base_uri");

    private static final String PET = "pet";



    private static RequestSpecification getRequest() {
        return given()
                .baseUri(BASE_URI)
                .headers(getHeaderSpecs())
                .when();
    }

    private static Map<String, Object> getHeaderSpecs() {
        Map<String, Object> headerSpecs = new HashMap<>();

        headerSpecs.put("Content-Type", ContentType.JSON);
        headerSpecs.put("Accept", ContentType.JSON);

        return headerSpecs;
    }

    public static void get(String endpoint) {
        response = getRequest().get(endpoint);
    }

    public static void post(String endpoint, Object reqBody) {
        response = getRequest().body(reqBody).post(endpoint);
    }

    public static void put(String endpoint, Object reqBody) {
        response = getRequest().body(reqBody).put(endpoint);
    }

    public static void delete(String endpoint) {
        getRequest().delete(endpoint).then().statusCode(200);
    }
    public static void verifySchema(){
        response.then().assertThat()
                .body(JsonSchemaValidator.
                        matchesJsonSchema(new File("src/test/resources/schema/pet.json")));
    }
}
