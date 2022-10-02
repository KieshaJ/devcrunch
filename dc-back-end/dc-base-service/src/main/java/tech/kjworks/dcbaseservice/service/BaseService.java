package tech.kjworks.dcbaseservice.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<T> {
    public List<T> list();
    public T create(T entity);
    public T update(String id, T entity);
    public Optional<T> get(String id);
    public Boolean delete(String id);
}
