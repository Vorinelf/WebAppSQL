package com.artem.dao;

import com.artem.headphones.Headphones;
import com.artem.users.User;

import java.util.List;

public interface Dao<T extends Headphones> {
    List<Headphones> findAll();

    List<Headphones> findByBlue(String blue);

    List<Headphones> findByHiRes(String hiRes);

    List<Headphones> findByPrice (int priceFrom, int priceTo);

    List<Headphones> findByName(String name);

    List<Headphones> findByConstruction(String construct);

    List<Headphones> findByStock(String stock);

    List<Headphones> findAndSortByPrice (String column, String highOrLow);

    List<Headphones> findAndSortBy(String column);

    boolean saveOrderInBase(List<Headphones> listHeadphones, User user);

    T findEntityById(int id);

    boolean create(T entity);

    boolean delete(int id);

    boolean update(T entity);




}
