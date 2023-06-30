package tech.kjworks.dcpostservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import tech.kjworks.dcpostservice.service.PostService;
import tech.kjworks.dcpostservice.util.dto.PostDTO;

@RestController
@RequestMapping(path = "/posts")
@Tag(name = "Posts")
public class PostController {
    @Autowired
    private PostService service;

    @PostMapping(path = "/list")
    public ResponseEntity<List<PostDTO>> list() {
        List<PostDTO> dtoList = service.list();
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<PostDTO> create(@Valid @RequestBody PostDTO post) {
        PostDTO dto = service.create(post);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping(path = "/createSolution/{id}")
    public ResponseEntity<PostDTO> createSolution(@PathVariable String problemId, @Valid @RequestBody PostDTO solution) {
        PostDTO dto = service.createSolution(problemId, solution);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<PostDTO> update(@PathVariable String id, @Valid @RequestBody PostDTO post) {
        PostDTO dto = service.update(id, post);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PostDTO> get(@PathVariable String id) {
        PostDTO dto = service.get(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        boolean deleted = service.delete(id);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }
}
