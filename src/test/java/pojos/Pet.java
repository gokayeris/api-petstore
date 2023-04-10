package pojos;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;

@Getter
@Setter
@ToString
@FieldNameConstants
@JsonIgnoreProperties(ignoreUnknown=true)
public class Pet {
    private int id;
    private String name;
    private String status;

    public Pet(String id, String name, String status) {
        this.id = Integer.parseInt(id);
        this.name = name;
        this.status = status;
    }
}
