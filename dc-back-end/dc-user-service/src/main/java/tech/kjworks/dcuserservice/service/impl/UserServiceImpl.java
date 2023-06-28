package tech.kjworks.dcuserservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.kjworks.dcuserservice.model.User;
import tech.kjworks.dcuserservice.repository.UserRepository;
import tech.kjworks.dcuserservice.service.UserService;
import tech.kjworks.dcuserservice.util.data.UserDataUtils;
import tech.kjworks.dcuserservice.util.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> list() {
        List<User> users = userRepository.findAll();
        return UserDataUtils.toDTOList(users);
    }

    @Override
    public UserDTO create(UserDTO dto) {
        User entity = UserDataUtils.toModel(dto);
        entity = userRepository.insert(entity);
        return UserDataUtils.toDTO(entity);
    }

    @Override
    public UserDTO update(String id, UserDTO dto) {
        boolean exists = userRepository.existsById(id);
        if (exists) {
            User entity = UserDataUtils.toModel(dto);
            entity = userRepository.save(entity);
            return UserDataUtils.toDTO(entity);
        }
        return null;
    }

    @Override
    public UserDTO get(String id) {
        User entity = userRepository.findById(id).orElse(null);
        return UserDataUtils.toDTO(entity);
    }

    @Override
    public Boolean delete(String id) {
        boolean exists = userRepository.existsById(id);
        if (exists) {
            userRepository.deleteById(id);
        }
        return exists;
    }
}
