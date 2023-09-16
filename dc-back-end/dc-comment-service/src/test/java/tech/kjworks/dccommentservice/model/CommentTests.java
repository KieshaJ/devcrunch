package tech.kjworks.dccommentservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CommentTests {
    private ObjectId id;
    private Comment comment;

    @BeforeEach
    void init() {
        id = new ObjectId();
        comment = new Comment(id.toString(), "Id1", "Test comment");
    }

    @Test
    void CommentConstructor() {
        assertEquals(id.toString(), comment.getId());
    }

    @Test
    void CommentGetters() {
        assertEquals("Id1", comment.getAuthorId());
        assertEquals("Test comment", comment.getContent());
    }

    @Test
    void CommentSetters() {
        String newAuthorId = "Id2";
        String newContent = "New comment";

        comment.setAuthorId(newAuthorId);
        comment.setContent(newContent);

        assertEquals(newAuthorId, comment.getAuthorId());
        assertEquals(newContent, comment.getContent());
    }
}
