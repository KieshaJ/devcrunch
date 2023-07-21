package tech.kjworks.dcpostservice.util.dto;

import java.util.List;

import tech.kjworks.dcpostservice.util.enums.ContentType;

public record ContentBlockDTO(
        Integer order,
        ContentType contentType,
        String content,
        List<String> commentIds) {

}
