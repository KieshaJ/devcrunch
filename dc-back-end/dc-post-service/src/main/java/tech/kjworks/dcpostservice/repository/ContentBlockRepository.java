package tech.kjworks.dcpostservice.repository;

import org.springframework.stereotype.Repository;

import tech.kjworks.dcbaseservice.repository.BaseRepository;
import tech.kjworks.dcpostservice.model.ContentBlock;

@Repository
public interface ContentBlockRepository extends BaseRepository<ContentBlock> {
    
}
