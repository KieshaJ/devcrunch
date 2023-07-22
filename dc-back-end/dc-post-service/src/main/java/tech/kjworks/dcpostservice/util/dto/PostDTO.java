package tech.kjworks.dcpostservice.util.dto;

import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import tech.kjworks.dcpostservice.util.enums.PostType;

public record PostDTO(
        String id,
        Date createdAt,
        Date updatedAt,
        @NotNull(message = "Post type required")
        PostType type,
        @NotNull(message = "Author required, please log in")
        String authorId,
        @Size(min = 10,
                max = 256,
                message = "Title should be between 10 and 256 characters long")
        String title,
        List<ContentBlockDTO> contentList,
        List<PostDTO> solutionList,
        List<String> commentIdList) {

}
