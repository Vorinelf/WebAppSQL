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
                    ("INSERT INTO user_data (user_firstName, user_secondName, user_login, user_password, user_isAdmin) Values (?,?,?,?,?)");
            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2, entity.getSecondName());
            preparedStatement.setString(3, entity.getLogin());
            preparedStatement.setString(4, entity.getPassword());
            preparedStatement.setString(5, String.valueOf(entity.isAdmin()));
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
                    ("SELECT * FROM user_data WHERE user_login=? AND user_password=? limit 1");
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String firstName = resultSet.getString(2);
                String secondName = resultSet.getString(3);
                String log = resultSet.getString(4);
                String passw = resultSet.getString(5);
                Boolean isAdmin = resultSet.getBoolean(6);
                user = new User(firstName,secondName,log,passw,isAdmin);
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
