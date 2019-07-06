package com.artem.methods;

import com.artem.connect.ConnectionPool;
import com.artem.dao.DaoUser;
import com.artem.headphones.Headphones;
import com.artem.users.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserMethods implements DaoUser {

    private static final UserMethods INSTANCE = new UserMethods();

    public static UserMethods getInstance() {
        return INSTANCE;
    }

    private Connection connection = ConnectionPool.getInstance().getConnection();

    private UserMethods() {
    }

    @Override
    public boolean registration(User entity) {
        boolean flag = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("INSERT INTO users (isAdmin, login, password, firstName, secondName, country, city, street, postIndex, phone) Values (?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1,entity.getIsAdmin());
            preparedStatement.setString(2, entity.getLogin());
            preparedStatement.setString(3, entity.getPassword());
            preparedStatement.setString(4, entity.getFirstName());
            preparedStatement.setString(5, entity.getSecondName());
            preparedStatement.setString(6, entity.getCountry());
            preparedStatement.setString(7, entity.getCity());
            preparedStatement.setString(8, entity.getStreet());
            preparedStatement.setString(9, entity.getPostIndex());
            preparedStatement.setString(10, entity.getPhone());
            preparedStatement.executeUpdate();
            flag = true;
            preparedStatement.close();
            if (connection != null) {
                ConnectionPool.getInstance().closeConnection(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }


    @Override
    public User checkLoginOrNewUser(String login, String password) {
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT * FROM users WHERE login=? AND password=? limit 1");
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String isAdmin = resultSet.getString(2);
                String log = resultSet.getString(3);
                String passw = resultSet.getString(4);
                String firstName = resultSet.getString(5);
                String secondName = resultSet.getString(6);
                String country = resultSet.getString(7);
                String city = resultSet.getString(8);
                String street = resultSet.getString(9);
                String postIndex = resultSet.getString(10);
                String phone = resultSet.getString(11);
                user = new User(id, isAdmin, log, passw, firstName, secondName, country, city, street, postIndex, phone);
            }
            preparedStatement.close();
            if (connection != null) {
                ConnectionPool.getInstance().closeConnection(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    @Override
    public List<User> findAllUsers() {
        List<User> usersArray = new ArrayList<>();
        User user;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String isAdmin = resultSet.getString(2);
                String log = resultSet.getString(3);
                String passw = resultSet.getString(4);
                String firstName = resultSet.getString(5);
                String secondName = resultSet.getString(6);
                String country = resultSet.getString(7);
                String city = resultSet.getString(8);
                String street = resultSet.getString(9);
                String postIndex = resultSet.getString(10);
                String phone = resultSet.getString(11);
                user = new User(id, isAdmin, log, passw, firstName, secondName, country, city, street, postIndex, phone);
                usersArray.add(user);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            ConnectionPool.getInstance().closeConnection(connection);
        }
        return usersArray;
    }


    @Override
    public boolean deleteUser(int id) {
        boolean flag = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("DELETE FROM users WHERE id=?");
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
}
