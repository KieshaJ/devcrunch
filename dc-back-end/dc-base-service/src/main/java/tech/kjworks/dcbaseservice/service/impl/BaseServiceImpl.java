package tech.kjworks.dcbaseservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.kjworks.dcbaseservice.repository.BaseRepository;
import tech.kjworks.dcbaseservice.service.BaseService;

@Service
public class BaseServiceImpl<T> implements BaseService<T> {
    @Autowired
    private BaseRepository<T> repository;

    @Override
    public List<T> list() {
        return repository.findAll();
    }

    @Override
    public T create(T entity) {
        return repository.insert(entity);
    }

    @Override
    public T update(String id, T entity) {
        return repository.save(entity);
    }

    @Override
    public Optional<T> get(String id) {
        return repository.findById(id);
    }

    @Override
    public Boolean delete(String id) {
        repository.deleteById(id);
        return true;
    }
}
