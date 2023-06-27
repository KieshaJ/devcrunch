package tech.kjworks.dcpostservice.model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import tech.kjworks.dcbaseservice.model.BaseModel;
import tech.kjworks.dcpostservice.util.enums.ContentType;

@Getter
@Setter
@Document(collection = "contentBlocks")
public class ContentBlock extends BaseModel {
    @NotNull
    private ContentType type;
    @NotNull
    @Size(min = 10, max = 4096)
    private String content;

    public ContentBlock(String id, ContentType type, String content) {
        super(id);
        this.type = type;
        this.content = content;
    }
}
