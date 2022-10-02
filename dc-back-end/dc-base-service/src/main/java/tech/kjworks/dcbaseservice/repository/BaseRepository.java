package tech.kjworks.dcbaseservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseRepository<T> extends MongoRepository<T, String> {
    
}
