package com.artem.dao;

import com.artem.device.Device;

import java.util.List;

public interface Dao <T extends Device> {
    List<T> findAll();

    void delete(int id);

    void update(T entity);

    void save(T entity);

    T findEntityById(int id);
}
