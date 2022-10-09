package tech.kjworks.dcpostservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.kjworks.dcpostservice.model.Post;
import tech.kjworks.dcpostservice.repository.PostRepository;
import tech.kjworks.dcpostservice.service.PostService;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> list() {
        return postRepository.findAll();
    }

    @Override
    public Post create(Post entity) {
        return postRepository.insert(entity);
    }

    @Override
    public Post update(String id, Post entity) {
        boolean exists = postRepository.existsById(id);
        if (exists) {
            return postRepository.save(entity);
        }
        return null;
    }

    @Override
    public Post get(String id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean delete(String id) {
        boolean exists = postRepository.existsById(id);
        if (exists) {
            postRepository.deleteById(id);
        }
        return exists;
    }
}
