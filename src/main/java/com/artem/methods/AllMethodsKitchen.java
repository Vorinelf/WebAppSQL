package com.artem.methods;

import com.artem.dao.Dao;
import com.artem.device.Device;

import java.util.List;

public class AllMethodsKitchen implements Dao<Device> {
    @Override
    public List<Device> findAll() {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Device entity) {

    }

    @Override
    public void save(Device entity) {

    }

    @Override
    public Device findEntityById(int id) {
        return null;
    }
}
