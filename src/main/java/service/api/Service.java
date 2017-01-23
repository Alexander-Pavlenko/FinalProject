package service.api;

import model.Entity;

import java.util.List;

/**
 * Created by Alexandr on 16.12.2016.
 */
public interface Service<K,T extends Entity<K>> {
    List<T> getAll();
    T getById(K id);
    T save(T entity);
    void delete(K key);
    void update(T entity);

}
