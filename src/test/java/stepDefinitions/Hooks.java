package stepDefinitions;

import io.cucumber.java.After;
import pojos.Pet;
import utilities.Api;
import utilities.ConfigReader;

public class Hooks {
    @After("@deletePet")
    public void deletePet(){
        String petId = System.getProperty(Pet.Fields.id);
        Api.delete(String.format("%s%s", ConfigReader.getProperty("pet"), petId));
    }
}
