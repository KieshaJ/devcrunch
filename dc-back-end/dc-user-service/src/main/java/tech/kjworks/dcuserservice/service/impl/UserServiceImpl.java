package tech.kjworks.dcuserservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.kjworks.dcuserservice.model.User;
import tech.kjworks.dcuserservice.repository.UserRepository;
import tech.kjworks.dcuserservice.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    @Override
    public User create(User entity) {
        return userRepository.insert(entity);
    }

    @Override
    public User update(String id, User entity) {
        boolean exists = userRepository.existsById(id);
        if (exists) {
            return userRepository.save(entity);
        }
        return null;
    }

    @Override
    public User get(String id) {
        return userRepository.findById(id).orElse(null);
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
