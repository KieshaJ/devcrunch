package tech.kjworks.dcuserservice.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import tech.kjworks.dcbaseservice.model.BaseModel;
import tech.kjworks.dcuserservice.util.enums.UserRole;

@Getter
@Setter
@Document(collection = "users")
public class User extends BaseModel {
    @NotNull(message = "First name can not be empty")
    private String firstName;
    @NotNull(message = "Last name can not be empty")
    private String lastName;
    @NotNull(message = "Email name can not be empty")
    @Email(message = "You have to enter a valid email address")
    private String email;
    private List<UserRole> roles;

    public User(String id,
        String firstName,
        String lastName,
        String email,
        List<UserRole> roles) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roles = roles;
    }
}
