package tech.kjworks.dcuserservice.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

import tech.kjworks.dcbaseservice.model.BaseModel;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
