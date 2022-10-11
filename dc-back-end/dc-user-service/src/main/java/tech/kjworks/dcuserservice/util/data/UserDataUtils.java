package tech.kjworks.dcuserservice.util.data;

import java.util.List;

import tech.kjworks.dcuserservice.model.User;
import tech.kjworks.dcuserservice.util.dto.UserDTO;

public class UserDataUtils {
    private UserDataUtils() {}

    public static UserDTO toDTO(User model) {
        return new UserDTO(
            model.getId(),
            model.getCreatedAt(),
            model.getUpdatedAt(),
            model.getFirstName(),
            model.getLastName(),
            null,
            null,
            null
        );
    }

    public static List<UserDTO> toDTOList(List<User> modelList) {
        return modelList.stream().map(UserDataUtils::toDTO).toList();
    }

    public static User toModel(UserDTO dto) {
        return new User(
            dto.id(),
            dto.firstName(),
            dto.lastName()
        );
    }

    public static List<User> toModelList(List<UserDTO> dtoList) {
        return dtoList.stream().map(UserDataUtils::toModel).toList();
    }
}
