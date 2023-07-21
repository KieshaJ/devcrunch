package tech.kjworks.dcpostservice.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import tech.kjworks.dcbaseservice.model.BaseModel;
import tech.kjworks.dcpostservice.util.enums.PostType;

@Getter
@Setter
@Document(collection = "posts")
public class Post extends BaseModel {
    @NotNull(message = "Post type required")
    private PostType type;
    @NotNull(message = "Author required, please log in")
    private String authorId;
    @NotNull(message = "Title can not be empty")
    @Size(min = 10, max = 256)
    private String title;
    private List<ContentBlock> contentList;
    @DBRef
    private List<Post> solutionList;
    private List<String> commentIds;

    public Post(String id,
            PostType type,
            String authorId,
            String title,
            List<ContentBlock> contentList,
            List<Post> solutionList,
            List<String> commentIds) {
        super(id);
        this.type = type;
        this.authorId = authorId;
        this.title = title;
        this.contentList = contentList;
        this.solutionList = solutionList;
        this.commentIds = commentIds;
    }
}
