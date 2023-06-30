package tech.kjworks.dcpostservice.repository;

// import static org.junit.jupiter.api.Assertions.assertTrue;

// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

// import tech.kjworks.dcpostservice.model.Post;
// import tech.kjworks.dcpostservice.util.enums.PostType;

// @DataMongoTest
// public class PostRepositoryTests {
//     @Autowired
//     private PostRepository repository;

//     @BeforeEach
//     void setUp() {
//         Post post1 = new Post(null, PostType.PROBLEM, "1", "One", null, null, null);
//         Post post2 = new Post(null, PostType.PROBLEM, "2", "Two", null, null, null);

//         repository.save(post1);
//         repository.save(post2);
//     }

//     @AfterEach
//     void teardown() {
//         repository.deleteAll();
//     }

//     @Test
//     void postRepository_saveSuccess() {
//         assertTrue(true);
//     }
// }
