package tech.kjworks.dccommentservice.model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import tech.kjworks.dcbaseservice.model.BaseModel;

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

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
