package tech.kjworks.dccommentservice.repository;

import org.springframework.stereotype.Repository;

import tech.kjworks.dcbaseservice.repository.BaseRepository;
import tech.kjworks.dccommentservice.model.Comment;

@Repository
public interface CommentRepository extends BaseRepository<Comment> {
    
}
