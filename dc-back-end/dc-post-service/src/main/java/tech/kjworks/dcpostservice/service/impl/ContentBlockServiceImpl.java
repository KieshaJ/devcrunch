package tech.kjworks.dcpostservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.kjworks.dcpostservice.model.ContentBlock;
import tech.kjworks.dcpostservice.repository.ContentBlockRepository;
import tech.kjworks.dcpostservice.service.ContentBlockService;

@Service
public class ContentBlockServiceImpl implements ContentBlockService {
    @Autowired
    private ContentBlockRepository contentBlockRepository;

    @Override
    public List<ContentBlock> list() {
        return contentBlockRepository.findAll();
    }

    @Override
    public ContentBlock create(ContentBlock entity) {
        return contentBlockRepository.insert(entity);
    }

    @Override
    public ContentBlock update(String id, ContentBlock entity) {
        return contentBlockRepository.save(entity);
    }

    @Override
    public ContentBlock get(String id) {
        return contentBlockRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean delete(String id) {
        contentBlockRepository.deleteById(id);
        return true;
    }
    
}
