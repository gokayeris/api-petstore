package pojos;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown=true)
public class Pet {
    private String id;
    private String name;
    private String status;

    public Pet(String id, String name, String status) {
//        this.id = Integer.parseInt(id);
        this.id = Integer.toString(Integer.parseInt(id));
        this.name = name;
        this.status = status;
    }
}
