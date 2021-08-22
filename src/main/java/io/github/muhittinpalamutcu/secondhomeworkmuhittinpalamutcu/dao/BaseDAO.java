package io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.dao;

import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BaseDAO<T> {
    List<T> findAll();

    T findById(int id);

    T save(T object);

    T updateById(int id, T object);

    void deleteById(int id);
}
