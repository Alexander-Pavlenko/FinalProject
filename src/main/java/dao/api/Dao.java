package dao.api;

/**
 * Created by Alexandr on 16.12.2016.
 */

import model.Entity;

import java.util.List;

public interface Dao<K, T extends Entity<K>> {
    List<T> getAll();
    T getById(K key);
    T save(T entity);
    void delete(K key);
    void update(T entity);
}