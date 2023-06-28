package tech.kjworks.dcpostservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.kjworks.dcpostservice.model.Post;
import tech.kjworks.dcpostservice.repository.PostRepository;
import tech.kjworks.dcpostservice.service.PostService;
import tech.kjworks.dcpostservice.util.data.PostDataUtils;
import tech.kjworks.dcpostservice.util.dto.PostDTO;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public List<PostDTO> list() {
        List<Post> posts = postRepository.findAll();
        return PostDataUtils.toDTOList(posts);
    }

    @Override
    public PostDTO create(PostDTO dto) {
        Post entity = PostDataUtils.toModel(dto);
        entity = postRepository.insert(entity);
        return PostDataUtils.toDTO(entity);
    }

    @Override
    public PostDTO update(String id, PostDTO dto) {
        boolean exists = postRepository.existsById(id);
        if (exists) {
            Post entity = PostDataUtils.toModel(dto);
            entity = postRepository.save(entity);
            return PostDataUtils.toDTO(entity);
        }
        return null;
    }

    @Override
    public PostDTO get(String id) {
        Post entity = postRepository.findById(id).orElse(null);
        return PostDataUtils.toDTO(entity);
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
