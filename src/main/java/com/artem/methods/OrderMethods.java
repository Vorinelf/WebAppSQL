package com.artem.methods;

import com.artem.connect.ConnectionPool;
import com.artem.dao.DaoOrder;
import com.artem.headphones.Headphones;
import com.artem.order.Order;
import com.artem.users.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderMethods implements DaoOrder {

    private static final OrderMethods INSTANCE = new OrderMethods();

    public static OrderMethods getInstance() {
        return INSTANCE;
    }

    private Connection connection = ConnectionPool.getInstance().getConnection();

    private OrderMethods(){}

    @Override
    public boolean saveOrderInBase(List<Headphones> listHeadphones, User user) {
        boolean flag = false;
        Date date = new Date();
        try {
            for (Headphones hd : listHeadphones) {
                PreparedStatement preparedStatement = connection.prepareStatement
                        ("INSERT INTO orders (dateOrder, firstName, secondName, brand, model, price, country, city, street, postIndex, phone) Values (?,?,?,?,?,?,?,?,?,?,?)");
                preparedStatement.setString(1, date.toString());
                preparedStatement.setString(2, user.getFirstName());
                preparedStatement.setString(3, user.getSecondName());
                preparedStatement.setString(4, hd.getName());
                preparedStatement.setString(5, hd.getModel());
                preparedStatement.setInt(6, hd.getPrice());
                preparedStatement.setString(7, user.getCountry());
                preparedStatement.setString(8, user.getCity());
                preparedStatement.setString(9, user.getStreet());
                preparedStatement.setString(10, user.getPostIndex());
                preparedStatement.setString(11, user.getPhone());
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            flag = true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().closeConnection(connection);
        }
        return flag;
    }


    @Override
    public List<Order> findAllOrders() {
        List<Order> ordersArray = new ArrayList<>();
        Order order;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM orders");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String dateOrder = resultSet.getString(2);
                String firstName = resultSet.getString(3);
                String secondName = resultSet.getString(4);
                String brand = resultSet.getString(5);
                String model = resultSet.getString(6);
                int price = resultSet.getInt(7);
                String country = resultSet.getString(8);
                String city = resultSet.getString(9);
                String street = resultSet.getString(10);
                String postIndex = resultSet.getString(11);
                String phone = resultSet.getString(12);
                order = new Order(id, dateOrder, firstName, secondName, brand, model, price, country, city, street, postIndex, phone);
                ordersArray.add(order);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            ConnectionPool.getInstance().closeConnection(connection);
        }
        return ordersArray;
    }

    @Override
    public boolean deleteOrder(int id) {
        boolean flag = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("DELETE FROM orders WHERE id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            flag = true;
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().closeConnection(connection);
        }
        return flag;
    }

    @Override
    public boolean deleteAllOrders() {
        boolean flag = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("DELETE FROM orders");
            preparedStatement.executeUpdate();
            flag = true;
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().closeConnection(connection);
        }
        return flag;
    }

}
