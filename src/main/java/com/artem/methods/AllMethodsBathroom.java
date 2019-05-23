package com.artem.methods;

import com.artem.connect.ConnectionPoolNew;
import com.artem.dao.Dao;
import com.artem.device.BathroomDevice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AllMethodsBathroom implements Dao<BathroomDevice> {


    Connection connection = ConnectionPoolNew.getInstance().getConnection();


    @Override
    public List<BathroomDevice> findAll() {
        List<BathroomDevice> bathroomDevicesArray = new ArrayList();
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
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                ConnectionPoolNew.getInstance().closeConnection(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bathroomDevicesArray;
    }

    @Override
    public BathroomDevice findEntityById(int id) {
        BathroomDevice bathroomDevice = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT * FROM bathroom_device WHERE id_bathroom_device=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idBathroom = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int powerSize = resultSet.getInt(3);
                boolean powerOn = resultSet.getBoolean(4);
                boolean waterProof = resultSet.getBoolean(5);
                bathroomDevice = new BathroomDevice(idBathroom, name, powerSize, powerOn, waterProof);

            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                ConnectionPoolNew.getInstance().closeConnection(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bathroomDevice;
    }

    @Override
    public boolean delete(int id) {
        boolean flag = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("DELETE FROM bathroom_device WHERE id_bathroom_device=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            flag = true;
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                ConnectionPoolNew.getInstance().closeConnection(connection);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;

    }

    @Override
    public boolean update(BathroomDevice bathroomDevice) {
        boolean flag = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("UPDATE bathroom_device SET bathroom_name=?, bathroom_powerSize_kW=?, bathroom_powerON=?, bathroom_waterProof=? WHERE id_bathroom_device=?");
            preparedStatement.setString(1, bathroomDevice.getName());
            preparedStatement.setInt(2, bathroomDevice.getPowerSizekW());
            preparedStatement.setBoolean(3, bathroomDevice.isPowerON());
            preparedStatement.setBoolean(4, bathroomDevice.isWaterproof());
            preparedStatement.setInt(5, bathroomDevice.getId());
            preparedStatement.executeUpdate();
            flag = true;
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                ConnectionPoolNew.getInstance().closeConnection(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public boolean create(BathroomDevice entity) {
        boolean flag = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("INSERT INTO bathroom_device (id_bathroom_device, bathroom_name, bathroom_powerSize_kW, bathroom_powerON, bathroom_waterProof) Values (?,?,?,?,?)");
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getName());
            preparedStatement.setInt(3, entity.getPowerSizekW());
            preparedStatement.setBoolean(4, entity.isPowerON());
            preparedStatement.setBoolean(5, entity.isWaterproof());
            preparedStatement.executeUpdate();
            flag = true;
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                ConnectionPoolNew.getInstance().closeConnection(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;


    }
}
