package tech.kjworks.dccommentservice.model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import tech.kjworks.dcbaseservice.model.BaseModel;

@Getter
@Setter
@Document(collection = "comments")
public class Comment extends BaseModel {
    @NotNull(message = "Author required, please log in")
    private String authorId;
    @NotNull(message = "Comment can not be empty")
    @Size(min = 10, max = 256)
    private String content;

    public Comment(String id,
        String authorId,
        String content) {
        super(id);
        this.authorId = authorId;
        this.content = content;
    }
}
