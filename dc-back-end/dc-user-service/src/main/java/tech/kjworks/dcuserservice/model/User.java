package tech.kjworks.dcuserservice.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import tech.kjworks.dcbaseservice.model.BaseModel;

@Getter
@Setter
@Document(collection = "users")
public class User extends BaseModel {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    // roles, avatar, email,  

    public User(String id, String firstName, String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
