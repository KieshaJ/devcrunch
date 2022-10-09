package tech.kjworks.dcpostservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import tech.kjworks.dcpostservice.model.ContentBlock;
import tech.kjworks.dcpostservice.service.ContentBlockService;
import tech.kjworks.dcpostservice.util.data.ContentBlockDataUtils;
import tech.kjworks.dcpostservice.util.dto.ContentBlockDTO;

@RestController
@RequestMapping(path = "/contentBlocks")
@Tag(name = "ContentBlocks")
public class ContentBlockController {
    @Autowired
    private ContentBlockService service;

    @PostMapping(path = "/list")
    public ResponseEntity<List<ContentBlockDTO>> list() {
        List<ContentBlock> entityList = service.list();
        List<ContentBlockDTO> dtoList = ContentBlockDataUtils.toDTOList(entityList);
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }
}
