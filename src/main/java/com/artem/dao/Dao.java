package com.artem.dao;

import com.artem.headphones.Headphones;

import java.util.List;

public interface Dao<T extends Headphones> {
    List<Headphones> findAll();

    List<Headphones> findByBlue(String blue);

    List<Headphones> findByHiRes(String hiRes);

    List<Headphones> findByPrice (int priceFrom, int priceTo);

    List<Headphones> findByName(String name);

    List<Headphones> findByConstruction(String construct);

    List<Headphones> findByStock(String stock);

    T findEntityById(int id);

    boolean create(T entity);

    boolean delete(int id);

    boolean update(T entity);




}
