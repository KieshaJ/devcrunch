package tech.kjworks.dccommentservice.util.dto;

import java.util.Date;

public record CommentDTO(
    String id,
    Date createdAt,
    Date updatedAt,
    String authorId,
    String content
) {
    
}
