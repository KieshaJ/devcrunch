package tech.kjworks.dcpostservice.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import tech.kjworks.dcpostservice.util.enums.ContentType;

@Getter
@Setter
public class ContentBlock {
    private Integer order;
    private ContentType type;
    private String content;
    private List<String> commentIds;

    public ContentBlock(Integer order,
            ContentType type,
            String content,
            List<String> commentIds) {
        this.order = order;
        this.type = type;
        this.content = content;
        this.commentIds = commentIds;
    }
}
