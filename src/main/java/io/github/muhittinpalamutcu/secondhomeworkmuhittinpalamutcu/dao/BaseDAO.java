package io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.dao;

import java.util.List;

public interface BaseDAO<T> {
    List<T> findAll();

    T findById(int id);

    T save(T object);

    T updateById(int id);

    void deleteById(int i);
}
