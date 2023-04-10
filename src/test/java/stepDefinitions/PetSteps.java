package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import pojos.Pet;
import utilities.Api;
import utilities.ConfigReader;


public class PetSteps {
    private static Pet pet;

    @When("^I want to (?:create a\\s|update the\\s)?pet with following details:$")
    public void i_want_to_create_a_pet_with_following_details(Pet petDt) {
        pet = petDt;
        System.setProperty(Pet.Fields.id, String.valueOf(pet.getId()));
    }

    @When("I have a pet with following details:$")
    public void i_have_a_pet_with_following_details(Pet petDt) {
        pet = petDt;
        Api.post(ConfigReader.getProperty("pet"), pet);
        System.setProperty(Pet.Fields.id, String.valueOf(pet.getId()));
    }

    @When("I do post request to create a pet")
    public void i_do_post_request_to_pet() {
        Api.post(ConfigReader.getProperty("pet"), pet);
    }

    @Then("verify that the status code is {int}")
    public void verify_that_the_status_code_is(int statusCode) {
        Api.response.then().assertThat().statusCode(statusCode);
    }

    @Then("verify that the response body for pet is like:")
    public void verify_that_the_response_body_for_pet_is_like(Pet petDt) {
        JsonPath jsonPath = Api.response.jsonPath();

        Assert.assertEquals(petDt.getId(), jsonPath.getInt(Pet.Fields.id));
        Assert.assertEquals(petDt.getName(), jsonPath.getString(Pet.Fields.name));
        Assert.assertEquals(petDt.getStatus(), jsonPath.getString(Pet.Fields.status));
    }

    @And("I do put request to update the pet")
    public void i_do_put_request_to_update_the_pet(){
        Api.put(ConfigReader.getProperty("pet"), pet);
    }

    @When("I send GET Request for pet with {string} id")
    public void i_send_get_request_for_pet_with_id(String endpoint) {
        Api.get(String.format("%s%s", ConfigReader.getProperty("pet"), endpoint));
    }

    @And("verify that the schema is correct")
    public void verify_that_the_schema_is_correct(){
        Api.verifySchema();
    }

}