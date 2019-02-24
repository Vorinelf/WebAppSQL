package com.artem.db;

import com.artem.connect.ConnectionPool;
import com.artem.device.KitchenDevice;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KitchenDeviceDB {
    private static org.apache.log4j.Logger logger = Logger.getLogger(KitchenDeviceDB.class);
    private static KitchenDeviceDB kitchenDeviceDB = null;

    private KitchenDeviceDB() {
    }

    public static KitchenDeviceDB getBathroomDeviceDB() {
        return kitchenDeviceDB = kitchenDeviceDB == null ? new KitchenDeviceDB() : kitchenDeviceDB;
    }

    public List<KitchenDevice> selectKitchenDevice() {
        logger.info("KITCHEN_DEVICE_DB: Start the method <selectKitchenDevice>");
        List<KitchenDevice> kitchenDevicesArray = new ArrayList<KitchenDevice>();
        try {
            Connection connection = (Connection) ConnectionPool.getConnectionPool().getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from kitchen_device");
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int powerSize = rs.getInt(3);
                boolean powerON = rs.getBoolean(4);
                int minT = rs.getInt(5);
                int maxT = rs.getInt(6);
                KitchenDevice kitchenDevice = new KitchenDevice(id, name, powerSize, powerON, minT, maxT);
                kitchenDevicesArray.add(kitchenDevice);
                ConnectionPool.getConnectionPool().returnConnection(connection);
            }
            if (stmt != null && rs != null) {
                stmt.close();
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("KITCHEN_DEVICE_DB: The method <selectBathroomDevice> is done successfully");
        return kitchenDevicesArray;
    }


    public KitchenDevice selectOneKitchenDevice(int id_kitchen_device) {
        logger.info("KITCHEN_DEVICE_DB: Start the method <selectOneKitchenDevice>");
        KitchenDevice kitchenDevice = null;
        try {
            Connection connection = (Connection) ConnectionPool.getConnectionPool().getConnection();
            String sql = "SELECT * FROM kitchen_device WHERE id_kitchen_device=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_kitchen_device);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int powerSize = rs.getInt(3);
                boolean powerON = rs.getBoolean(4);
                int minT = rs.getInt(5);
                int maxT = rs.getInt(6);
                kitchenDevice = new KitchenDevice(id, name, powerSize, powerON, minT, maxT);
                ConnectionPool.getConnectionPool().returnConnection(connection);
            }
            if (preparedStatement != null && rs != null) {
                preparedStatement.close();
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("KITCHEN_DEVICE_DB: The method <selectOneKitchenDevice> is done successfully");
        return kitchenDevice;
    }

    public int insert(KitchenDevice kitchenDevice) {
        logger.info("KITCHEN_DEVICE_DB: Start the method <insert>");
        try {
            Connection connection = (Connection) ConnectionPool.getConnectionPool().getConnection();
            String sql = "INSERT INTO kitchen_device (id_kitchen_device, kitchen_name, kitchen_powerSize_kW, kitchen_power_ON, kitchen_minTemperature, kitchen_maxTemperature) Values (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, kitchenDevice.getId());
            preparedStatement.setString(2, kitchenDevice.getName());
            preparedStatement.setInt(3, kitchenDevice.getPowerSizekW());
            preparedStatement.setBoolean(4, kitchenDevice.isPowerON());
            preparedStatement.setInt(5, kitchenDevice.getMinTemperature());
            preparedStatement.setInt(6, kitchenDevice.getMaxTemperature());
            ConnectionPool.getConnectionPool().returnConnection(connection);
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            return preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("KITCHEN_DEVICE_DB: The method <insert> is done successfully");
        return 0;
    }

    public int update(KitchenDevice kitchenDevice) {
        logger.info("KITCHEN_DEVICE_DB: Start the method <update>");
        try {
            Connection connection = (Connection) ConnectionPool.getConnectionPool().getConnection();
            String sql = "UPDATE kitchen_device SET kitchen_name=?, kitchen_powerSize_kW=?, kitchen_power_ON=?, kitchen_minTemperature=?, kitchen_maxTemperature=? WHERE id_kitchen_device =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, kitchenDevice.getName());
            preparedStatement.setInt(2, kitchenDevice.getPowerSizekW());
            preparedStatement.setBoolean(3, kitchenDevice.isPowerON());
            preparedStatement.setInt(4, kitchenDevice.getMinTemperature());
            preparedStatement.setInt(5, kitchenDevice.getMaxTemperature());
            preparedStatement.setInt(6, kitchenDevice.getId());
            ConnectionPool.getConnectionPool().returnConnection(connection);
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        logger.info("KITCHEN_DEVICE_DB: The method <update> is done successfully");
        return 0;
    }

    public int delete(int id_kitchen_device) {
        logger.info("KITCHEN_DEVICE_DB: Start the method <delete>");
        try {
            Connection connection = (Connection) ConnectionPool.getConnectionPool().getConnection();
            String sql = "DELETE FROM kitchen_device WHERE id_kitchen_device =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_kitchen_device);
            ConnectionPool.getConnectionPool().returnConnection(connection);
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("KITCHEN_DEVICE_DB: The method <delete> is done successfully");
        return 0;
    }
}


