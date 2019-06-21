package com.artem.dao;

import com.artem.device.Device;

import java.util.List;

public interface Dao<T extends Device> {
    List<T> findAll();

    T findEntityById(int id);

    boolean create(T entity);

    boolean delete(int id);

    boolean update(T entity);



}
