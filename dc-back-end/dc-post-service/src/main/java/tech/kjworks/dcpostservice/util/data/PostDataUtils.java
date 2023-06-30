package tech.kjworks.dcpostservice.util.data;

import java.util.List;

import tech.kjworks.dcpostservice.model.Post;
import tech.kjworks.dcpostservice.util.dto.PostDTO;

public class PostDataUtils {
    private PostDataUtils() {}

    public static PostDTO toDTO(Post model) {
        return new PostDTO(
            model.getId(),
            model.getCreatedAt(),
            model.getUpdatedAt(),
            model.getType(),
            model.getAuthorId(),
            model.getTitle(),
            ContentBlockDataUtils.toDTOList(model.getContentList()),
            toDTOList(model.getSolutionList()),
            model.getCommentIds()
        );
    }

    public static List<PostDTO> toDTOList(List<Post> modelList) {
        return modelList.stream().map(PostDataUtils::toDTO).toList();
    }

    public static Post toModel(PostDTO dto) {
        return new Post(
            dto.id(),
            dto.type(),
            dto.authorId(),
            dto.title(),
            ContentBlockDataUtils.toModelList(dto.contentList()),
            toModelList(dto.solutionList()),
            dto.commentIdList()
        );
    }

    public static List<Post> toModelList(List<PostDTO> dtoList) {
        return dtoList.stream().map(PostDataUtils::toModel).toList();
    }
}
