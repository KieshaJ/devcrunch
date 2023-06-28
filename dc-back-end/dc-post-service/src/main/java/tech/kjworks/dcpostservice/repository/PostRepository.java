package tech.kjworks.dcpostservice.repository;

import tech.kjworks.dcbaseservice.repository.BaseRepository;
import tech.kjworks.dcpostservice.model.Post;
import java.util.List;
import tech.kjworks.dcpostservice.util.enums.PostType;

public interface PostRepository extends BaseRepository<Post> {
    public List<Post> findByTitleContaining(String title);
    public List<Post> findByType(PostType type);
}
