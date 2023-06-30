package tech.kjworks.dcpostservice.util.dto;

import java.util.Date;
import java.util.List;

import tech.kjworks.dcpostservice.util.enums.ContentType;

public record ContentBlockDTO(
        String id,
        Date createdAt,
        Date updatedAt,
        ContentType contentType,
        String content,
        List<String> commentIds) {

}
