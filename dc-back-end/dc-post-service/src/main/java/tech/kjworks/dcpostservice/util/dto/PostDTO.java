package tech.kjworks.dcpostservice.util.dto;

import java.util.Date;
import java.util.List;

import tech.kjworks.dcpostservice.util.enums.PostType;

public record PostDTO(
        String id,
        Date createdAt,
        Date updatedAt,
        PostType type,
        String authorId,
        String title,
        List<String> contentIdList,
        List<String> solutionIdList,
        List<String> commentIdList) {

}
