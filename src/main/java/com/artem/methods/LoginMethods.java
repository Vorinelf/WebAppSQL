package com.artem.methods;

import com.artem.connect.ConnectionPoolNew;
import com.artem.users.User;

import java.sql.*;


public class LoginMethods {
    private static final LoginMethods INSTANCE = new LoginMethods();

    public static LoginMethods getInstance() {
        return INSTANCE;
    }

    private Connection connection = ConnectionPoolNew.getInstance().getConnection();

    public boolean registration(User entity) {
        boolean flag = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("INSERT INTO users (isAdmin, login, password, firstName, secondName, country, city, street, postIndex, phone) Values (?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, String.valueOf(entity.isAdmin()));
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
                ConnectionPoolNew.getInstance().closeConnection(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public User checkLoginOrNewUser(String login, String password) {
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT * FROM users WHERE login=? AND password=? limit 1");
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Boolean isAdmin = resultSet.getBoolean(2);
                String log = resultSet.getString(3);
                String passw = resultSet.getString(4);
                String firstName = resultSet.getString(5);
                String secondName = resultSet.getString(6);
                String country = resultSet.getString(7);
                String city = resultSet.getString(8);
                String street = resultSet.getString(9);
                String postIndex = resultSet.getString(10);
                String phone = resultSet.getString(11);
                user = new User(isAdmin, log, passw, firstName, secondName, country, city, street, postIndex, phone);
            }
            preparedStatement.close();
            if (connection != null) {
                ConnectionPoolNew.getInstance().closeConnection(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


}
