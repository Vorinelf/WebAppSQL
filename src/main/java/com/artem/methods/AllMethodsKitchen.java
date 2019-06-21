package com.artem.methods;

import com.artem.dao.Dao;
import com.artem.device.KitchenDevice;

import java.util.List;

public class AllMethodsKitchen implements Dao<KitchenDevice> {


    @Override
    public List<KitchenDevice> findAll() {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(KitchenDevice entity) {
        return false;
    }


    @Override
    public boolean create(KitchenDevice entity) {
        return false;
    }

    @Override
    public KitchenDevice findEntityById(int id) {
        return null;
    }
}
