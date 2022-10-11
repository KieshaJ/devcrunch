package tech.kjworks.dcuserservice.repository;

import org.springframework.stereotype.Repository;

import tech.kjworks.dcbaseservice.repository.BaseRepository;
import tech.kjworks.dcuserservice.model.User;

@Repository
public interface UserRepository extends BaseRepository<User> {
    
}
