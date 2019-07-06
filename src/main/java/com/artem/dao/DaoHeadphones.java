package com.artem.dao;

import com.artem.headphones.Headphones;
import java.util.List;

public interface DaoHeadphones<T extends Headphones> {
    List<Headphones> findAll();

    List<Headphones> findByPrice(int priceFrom, int priceTo);

    List<Headphones> findAndSortByPrice(String column, String highOrLow);

    List<Headphones> findAndSortBy(String column);

    List<Headphones> findBy(String column, String param);

    T findEntityById(int id);

    boolean create(T entity);

    boolean delete(int id);

    boolean update(T entity);


}
