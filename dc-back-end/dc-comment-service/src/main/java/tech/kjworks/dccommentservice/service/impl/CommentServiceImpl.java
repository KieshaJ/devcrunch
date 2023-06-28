package tech.kjworks.dccommentservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.kjworks.dccommentservice.model.Comment;
import tech.kjworks.dccommentservice.repository.CommentRepository;
import tech.kjworks.dccommentservice.service.CommentService;
import tech.kjworks.dccommentservice.util.data.CommentDataUtils;
import tech.kjworks.dccommentservice.util.dto.CommentDTO;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<CommentDTO> list() {
        List<Comment> comments = commentRepository.findAll();
        return CommentDataUtils.toDTOList(comments);
    }

    @Override
    public CommentDTO create(CommentDTO dto) {
        Comment entity = CommentDataUtils.toModel(dto);
        entity = commentRepository.insert(entity);
        return CommentDataUtils.toDTO(entity);
    }

    @Override
    public CommentDTO update(String id, CommentDTO dto) {
        boolean exists = commentRepository.existsById(id);
        if (exists) {
            Comment entity = CommentDataUtils.toModel(dto);
            entity = commentRepository.save(entity);
            return CommentDataUtils.toDTO(entity);
        }
        return null;
    }

    @Override
    public CommentDTO get(String id) {
        Comment entity = commentRepository.findById(id).orElse(null);
        return CommentDataUtils.toDTO(entity);
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
