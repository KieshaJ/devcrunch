package tech.kjworks.dccommentservice.util.data;

import java.util.List;

import tech.kjworks.dccommentservice.model.Comment;
import tech.kjworks.dccommentservice.util.dto.CommentDTO;

public class CommentDataUtils {
    private CommentDataUtils() {}

    public static CommentDTO toDTO(Comment model) {
        return new CommentDTO(
            model.getId(),
            model.getCreatedAt(),
            model.getUpdatedAt(),
            model.getAuthorId(),
            model.getPostId(),
            model.getContent()
        );
    }

    public static List<CommentDTO> toDTOList(List<Comment> modelList) {
        return modelList.stream().map(CommentDataUtils::toDTO).toList();
    }

    public static Comment toModel(CommentDTO dto) {
        return new Comment(
            dto.id(),
            dto.authorId(),
            dto.postId(),
            dto.content()
        );
    }

    public static List<Comment> toModelList(List<CommentDTO> dtoList) {
        return dtoList.stream().map(CommentDataUtils::toModel).toList();
    }
}
