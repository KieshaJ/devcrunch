package tech.kjworks.dccommentservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.kjworks.dccommentservice.model.Comment;
import tech.kjworks.dccommentservice.repository.CommentRepository;
import tech.kjworks.dccommentservice.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> list() {
        return commentRepository.findAll();
    }

    @Override
    public Comment create(Comment entity) {
        return commentRepository.insert(entity);
    }

    @Override
    public Comment update(String id, Comment entity) {
        boolean exists = commentRepository.existsById(id);
        if (exists) {
            return commentRepository.save(entity);
        }
        return null;
    }

    @Override
    public Comment get(String id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean delete(String id) {
        boolean exists = commentRepository.existsById(id);
        if (exists) {
            commentRepository.deleteById(id);
        }
        return exists;
    }
}
