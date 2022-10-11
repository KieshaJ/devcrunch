package tech.kjworks.dcuserservice.util.dto;

import java.util.Date;
import java.util.List;

import tech.kjworks.dcuserservice.util.enums.UserRole;

public record UserDTO(
    String id,
    Date createdAt,
    Date updatedAt,
    String firstName,
    String lastName,
    String email,
    String avatarId,
    List<UserRole> roles
) {
    
}
