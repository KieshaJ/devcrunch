package tech.kjworks.dcpostservice.model;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import tech.kjworks.dcpostservice.util.enums.ContentType;

@Getter
@Setter
public class ContentBlock {
    @NotNull(message = "Order required")
    private Integer order;
    @NotNull(message = "Content type required")
    private ContentType type;
    @NotNull(message = "Content can not be empty")
    @Size(min = 10, max = 4096)
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
