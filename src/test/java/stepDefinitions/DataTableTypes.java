package stepDefinitions;

import io.cucumber.java.DataTableType;
import pojos.Pet;

import java.util.Map;

public class DataTableTypes {

    @DataTableType
    public Pet authorEntry(Map<String, String> entry) {
        return new Pet(
                entry.get("id"),
                entry.get("name"),
                entry.get("status"));
    }
}
