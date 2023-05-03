package tech.kjworks.dccommentservice.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import tech.kjworks.dcbaseservice.model.BaseModel;

@Getter
@Setter
@Document(collection = "comments")
public class Comment extends BaseModel {
    @NotNull
    private String authorId;
    @NotNull
    private String postId;
    @NotNull
    @Size(min = 10, max = 256)
    private String content;

    public Comment(String id, String authorId, String postId, String content) {
        super(id);
        this.authorId = authorId;
        this.postId = postId;
        this.content = content;
    }
}