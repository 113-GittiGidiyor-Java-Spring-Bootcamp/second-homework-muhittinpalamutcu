package io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.service;

import java.util.List;

public interface BaseService<T> {
    List<T> findAll();

    T findById(int id);

    T save(T object);

    T updateById(int id);

    void deleteById(int i);

}
