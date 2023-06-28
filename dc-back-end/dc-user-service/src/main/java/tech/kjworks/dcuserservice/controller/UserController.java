package tech.kjworks.dcuserservice.controller;

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
import tech.kjworks.dcuserservice.service.UserService;
import tech.kjworks.dcuserservice.util.dto.UserDTO;

@RestController
@RequestMapping(path = "/users")
@Tag(name = "Users")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping(path = "/list")
    public ResponseEntity<List<UserDTO>> list() {
        List<UserDTO> dtoList = service.list();
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO user) {
        UserDTO dto = service.create(user);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable String id, @RequestBody UserDTO user) {
        UserDTO dto = service.update(id, user);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserDTO> get(@PathVariable String id) {
        UserDTO dto = service.get(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        boolean deleted = service.delete(id);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }
}
