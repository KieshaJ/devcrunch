package tech.kjworks.dccommentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import tech.kjworks.dccommentservice.model.Comment;
import tech.kjworks.dccommentservice.service.CommentService;
import tech.kjworks.dccommentservice.util.data.CommentDataUtils;
import tech.kjworks.dccommentservice.util.dto.CommentDTO;

@RestController
@RequestMapping(path = "/comments")
@Tag(name = "Comments")
public class CommentController {
    @Autowired
    private CommentService service;

    @PostMapping(path = "/list")
    public ResponseEntity<List<CommentDTO>> list() {
        List<Comment> entityList = service.list();
        List<CommentDTO> dtoList = CommentDataUtils.toDTOList(entityList);
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<CommentDTO> create(@RequestBody CommentDTO user) {
        Comment entity = CommentDataUtils.toModel(user);
        entity = service.create(entity);
        CommentDTO dto = CommentDataUtils.toDTO(entity);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<CommentDTO> update(@PathVariable String id, @RequestBody CommentDTO user) {
        Comment entity = CommentDataUtils.toModel(user);
        entity = service.update(id, entity);
        CommentDTO dto = CommentDataUtils.toDTO(entity);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CommentDTO> get(@PathVariable String id) {
        Comment entity = service.get(id);
        CommentDTO dto = CommentDataUtils.toDTO(entity);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        boolean deleted = service.delete(id);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }
}
