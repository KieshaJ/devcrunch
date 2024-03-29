package tech.kjworks.dcpostservice.util.data;

import java.util.List;

import tech.kjworks.dcpostservice.model.ContentBlock;
import tech.kjworks.dcpostservice.util.dto.ContentBlockDTO;

public class ContentBlockDataUtils {
    private ContentBlockDataUtils() {}

    public static ContentBlockDTO toDTO(ContentBlock model) {
        return new ContentBlockDTO(
            model.getOrder(),
            model.getType(),
            model.getContent(),
            model.getCommentIds()
        );
    }

    public static List<ContentBlockDTO> toDTOList(List<ContentBlock> modelList) {
        return modelList.stream().map(ContentBlockDataUtils::toDTO).toList();
    }

    public static ContentBlock toModel(ContentBlockDTO dto) {
        return new ContentBlock(
            dto.order(),
            dto.contentType(),
            dto.content(),
            dto.commentIds()
        );
    }

    public static List<ContentBlock> toModelList(List<ContentBlockDTO> dtoList) {
        return dtoList.stream().map(ContentBlockDataUtils::toModel).toList();
    }
}
