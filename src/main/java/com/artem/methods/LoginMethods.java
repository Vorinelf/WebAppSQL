package com.artem.methods;

import com.artem.connect.ConnectionPoolNew;
import com.artem.device.BathroomDevice;
import com.artem.users.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginMethods {
    private static final LoginMethods INSTANCE = new LoginMethods();
    public static LoginMethods getInstance() {return INSTANCE;}
    private Connection connection = ConnectionPoolNew.getInstance().getConnection();

    public boolean registration (User entity) {
        boolean flag = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("INSERT INTO user_data (user_firstName, user_secondName, user_login, user_password) Values (?,?,?,?)");
            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2, entity.getSecondName());
            preparedStatement.setString(3, entity.getLogin());
            preparedStatement.setString(4, entity.getPassword());
            preparedStatement.executeUpdate();
            flag = true;
            preparedStatement.close();
            if (connection != null) {
                ConnectionPoolNew.getInstance().closeConnection(connection);
            }
        } catch (SQLException e) {
        }
        return flag;
    }

    public boolean checkUser (User entity) {
        boolean flag = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT * FROM user_data WHERE user_login=? AND user_password=?");

            preparedStatement.setString(1, entity.getLogin());
            preparedStatement.setString(2, entity.getPassword());
            preparedStatement.executeUpdate();
            flag = true;
            preparedStatement.close();
            if (connection != null) {
                ConnectionPoolNew.getInstance().closeConnection(connection);
            }
        } catch (SQLException e) {
        }
        return flag;


        List<BathroomDevice> users = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from bathroom_device");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int powerSize = resultSet.getInt(3);
                boolean powerON = resultSet.getBoolean(4);
                boolean waterproof = resultSet.getBoolean(5);
                BathroomDevice bathroomDevice = new BathroomDevice(id, name, powerSize, powerON, waterproof);
                bathroomDevicesArray.add(bathroomDevice);
            }
            statement.close();
            if (connection != null) {
                ConnectionPoolNew.getInstance().closeConnection(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bathroomDevicesArray;
    }

}
