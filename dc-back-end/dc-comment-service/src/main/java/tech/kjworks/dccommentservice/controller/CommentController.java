package tech.kjworks.dccommentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import tech.kjworks.dccommentservice.service.CommentService;
import tech.kjworks.dccommentservice.util.dto.CommentDTO;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/comments")
@Tag(name = "Comments")
public class CommentController {
    @Autowired
    private CommentService service;

    @PostMapping(path = "/list")
    public ResponseEntity<List<CommentDTO>> list() {
        List<CommentDTO> dtoList = service.list();
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<CommentDTO> create(@Valid @RequestBody CommentDTO user) {
        CommentDTO dto = service.create(user);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<CommentDTO> update(@PathVariable String id, @Valid @RequestBody CommentDTO user) {
        CommentDTO dto = service.update(id, user);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CommentDTO> get(@PathVariable String id) {
        CommentDTO dto = service.get(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        boolean deleted = service.delete(id);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }
}
