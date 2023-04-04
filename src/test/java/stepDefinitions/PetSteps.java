package stepDefinitions;

import io.cucumber.java.en.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.Pet;
import utilities.Api;
import utilities.ConfigReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PetSteps {
    private static final String PET = "pet";

    private static Pet pet;

    @Then("Response body is like:")
    public void response_body_is_like(Pet petDt) {

        JsonPath jsonPath = Api.response.jsonPath();

        Assert.assertEquals(petDt.getId(), jsonPath.getString("id"));
        Assert.assertEquals(petDt.getName(), jsonPath.getString("name"));
        Assert.assertEquals(petDt.getStatus(), jsonPath.getString("status"));
    }

    @When("^(?:I have a\\s|I want to update the\\s)?pet with following details:$")
    public void i_do_post_request_to_create_a_pet_with_following_details(Pet petDt) {
        pet = petDt;
    }

    @When("I do post request to create a pet")
    public void i_do_request_to_pet() {
        Api.post(PET, pet);
    }

    @Then("verify that the status code is {int}")
    public void verify_that_the_status_code_is(int statusCode) {
        Api.response.then().assertThat().statusCode(statusCode);
    }

    @Then("verify that the response body for pet is like:")
    public void verify_that_the_response_body_for_pet_is_like(Pet petDt) {
        JsonPath jsonPath = Api.response.jsonPath();

        Assert.assertEquals(petDt.getId(), jsonPath.getString("id"));
        Assert.assertEquals(petDt.getName(), jsonPath.getString("name"));
        Assert.assertEquals(petDt.getStatus(), jsonPath.getString("status"));

    }
    @And("I do put request to update the pet")
    public void i_do_put_request_to_update_the_pet(){
        Api.put(PET, pet);
    }

//    @Given("I have a pet with following details:")
//    public void i_have_a_pet_with_following_details(List<Map<String, Object>> dataTable) {
//        Map<String, Object> reqBodyDt = dataTable.get(0);
//
//        PetSteps.requestBodyMap.put("id", reqBodyDt.get("id"));
//        PetSteps.requestBodyMap.put("petId", reqBodyDt.get("petId"));
//        PetSteps.requestBodyMap.put("quantity", reqBodyDt.get("quantity"));
//        PetSteps.requestBodyMap.put("shipDate", reqBodyDt.get("shipDate"));
//        PetSteps.requestBodyMap.put("status", reqBodyDt.get("status"));
//        PetSteps.requestBodyMap.put("complete", reqBodyDt.get("complete"));
//    }

    @When("I send GET Request for pet with {string} id")
    public void i_send_get_request_for_pet_with_id(String endpoint) {
        Api.get("pet/" + endpoint);
    }
}