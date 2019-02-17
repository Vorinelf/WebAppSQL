package com.artem.DB;

import com.artem.connect.ConnectSql;
import com.artem.device.KitchenDevice;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

public class KitchenDeviceDB {
    private static org.apache.log4j.Logger logger = Logger.getLogger(KitchenDeviceDB.class);


    public static ArrayList<KitchenDevice> selectKitchenDevice() {
        logger.info("KITCHEN_DEVICE_DB: Start method <selectKitchenDevice>");

        ArrayList<KitchenDevice> kitchenDevicesArray = new ArrayList<KitchenDevice>();
        ConnectSql connectSql = new ConnectSql();
        try {
            logger.info("KITCHEN_DEVICE_DB:Start connection to database!");
            Class.forName(connectSql.getClassForName());
            Connection connection = DriverManager.getConnection(connectSql.getURL(), connectSql.getUserName(), connectSql.getPassWord());
            logger.info("KITCHEN_DEVICE_DB: Good connection!");
            Statement stmt = connection.createStatement();
            logger.info("KITCHEN_DEVICE_DB: Start selection!");
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
            }
            if (connection != null) {
                connection.close();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("KITCHEN_DEVICE_DB: Good selection!");
        return kitchenDevicesArray;
    }


    public static KitchenDevice selectOneKitchenDevice(int id_kitchen_device) {
        KitchenDevice kitchenDevice = null;
        ConnectSql connectSql = new ConnectSql();
        try {
            logger.info("KITCHEN_DEVICE_DB:Start connection to database!");
            Class.forName(connectSql.getClassForName());
            Connection connection = DriverManager.getConnection(connectSql.getURL(), connectSql.getUserName(), connectSql.getPassWord());
            logger.info("KITCHEN_DEVICE_DB: Good connection!");
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
            }
            if (connection != null) {
                connection.close();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("KITCHEN_DEVICE_DB: Good selection!");
        return kitchenDevice;
    }

    public static int insert(KitchenDevice kitchenDevice) {
        ConnectSql connectSql = new ConnectSql();
        try {
            logger.info("KITCHEN_DEVICE_DB:Start connection to database!");
            Class.forName(connectSql.getClassForName());
            Connection connection = DriverManager.getConnection(connectSql.getURL(), connectSql.getUserName(), connectSql.getPassWord());
            logger.info("KITCHEN_DEVICE_DB: Good connection!");
            String sql = "INSERT INTO kitchen_device (id_kitchen_device, kitchen_name, kitchen_powerSize_kW, kitchen_power_ON, kitchen_minTemperature, kitchen_maxTemperature) Values (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, kitchenDevice.getId());
            preparedStatement.setString(2, kitchenDevice.getName());
            preparedStatement.setInt(3, kitchenDevice.getPowerSizekW());
            preparedStatement.setBoolean(4, kitchenDevice.isPowerON());
            preparedStatement.setInt(5, kitchenDevice.getMinTemperature());
            preparedStatement.setInt(6, kitchenDevice.getMaxTemperature());
            return preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("KITCHEN_DEVICE_DB: Good selection!");
        return 0;
    }

    public static int update(KitchenDevice kitchenDevice) {
        ConnectSql connectSql = new ConnectSql();
        try {
            logger.info("KITCHEN_DEVICE_DB:Start connection to database!");
            Class.forName(connectSql.getClassForName());
            Connection connection = DriverManager.getConnection(connectSql.getURL(), connectSql.getUserName(), connectSql.getPassWord());
            logger.info("KITCHEN_DEVICE_DB: Good connection!");
            String sql = "UPDATE kitchen_device SET kitchen_name=?, kitchen_powerSize_kW=?, kitchen_power_ON=?, kitchen_minTemperature=?, kitchen_maxTemperature=? WHERE id_kitchen_device =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, kitchenDevice.getName());
            preparedStatement.setInt(2, kitchenDevice.getPowerSizekW());
            preparedStatement.setBoolean(3, kitchenDevice.isPowerON());
            preparedStatement.setInt(4, kitchenDevice.getMinTemperature());
            preparedStatement.setInt(5, kitchenDevice.getMaxTemperature());
            preparedStatement.setInt(6, kitchenDevice.getId());
            return preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("KITCHEN_DEVICE_DB: Good selection!");
        return 0;
    }

    public static int delete(int id_kitchen_device) {
        ConnectSql connectSql = new ConnectSql();
        try {
            logger.info("KITCHEN_DEVICE_DB:Start connection to database!");
            Class.forName(connectSql.getClassForName());
            Connection connection = DriverManager.getConnection(connectSql.getURL(), connectSql.getUserName(), connectSql.getPassWord());
            logger.info("KITCHEN_DEVICE_DB: Good connection!");
            String sql = "DELETE FROM kitchen_device WHERE id_kitchen_device =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_kitchen_device);
            return preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("KITCHEN_DEVICE_DB: Good selection!");
        return 0;
    }
}


