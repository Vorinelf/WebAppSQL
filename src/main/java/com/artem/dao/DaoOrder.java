package com.artem.dao;

import com.artem.headphones.Headphones;
import com.artem.order.Order;
import com.artem.users.User;

import java.util.List;

public interface DaoOrder {

    boolean saveOrderInBase(List<Headphones> listHeadphones, User user);

    List<Order> findAllOrders();

    boolean deleteOrder(int id);

    boolean deleteAllOrders();


}
