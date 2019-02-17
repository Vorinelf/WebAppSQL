package com.artem.DB;

import com.artem.connect.ConnectSql;
import com.artem.device.BathroomDevice;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

public class BathroomDeviceDB {
    private static org.apache.log4j.Logger logger = Logger.getLogger(KitchenDeviceDB.class);


    public static ArrayList<BathroomDevice> selectBatroomDevice() {
        logger.info("BATHROOM_DEVICE_DB: Start method <selectBathroomDevice>");

        ArrayList<BathroomDevice> bathroomDevicesArray = new ArrayList<BathroomDevice>();
        ConnectSql connectSql = new ConnectSql();
        try {
            logger.info("BATHROOM_DEVICE_DB:Start connection to database!");
            Class.forName(connectSql.getClassForName());
            Connection connection = DriverManager.getConnection(connectSql.getURL(), connectSql.getUserName(), connectSql.getPassWord());
            logger.info("BATHROOM_DB: Good connection!");
            Statement stmt = connection.createStatement();
            logger.info("BATHROOM_DEVICE_DB: Start selection!");
            ResultSet rs = stmt.executeQuery("select * from bathroom_device");

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int powerSize = rs.getInt(3);
                boolean powerON = rs.getBoolean(4);
                boolean waterproof = rs.getBoolean(5);

                BathroomDevice bathroomDevice = new BathroomDevice(id, name, powerSize, powerON, waterproof);
                bathroomDevicesArray.add(bathroomDevice);
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
        return bathroomDevicesArray;
    }


    public static BathroomDevice selectOneBathroomDevice(int id_bathroom_device) {
        BathroomDevice bathroomDevice = null;
        ConnectSql connectSql = new ConnectSql();
        try {
            logger.info("BATHROOM_DEVICE_DB:Start connection to database!");
            Class.forName(connectSql.getClassForName());
            Connection connection = DriverManager.getConnection(connectSql.getURL(), connectSql.getUserName(), connectSql.getPassWord());
            logger.info("BATHROOM_DEVICE_DB: Good connection!");
            logger.info("BATHROOM_DEVICE_DB: Start selection!");
            String sql = "SELECT * FROM bathroom_device WHERE id_bathroom_device=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_bathroom_device);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int powerSize = rs.getInt(3);
                boolean powerON = rs.getBoolean(4);
                boolean waterproof = rs.getBoolean(5);
                bathroomDevice = new BathroomDevice(id, name, powerSize, powerON, waterproof);
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
        return bathroomDevice;
    }

    public static int insert(BathroomDevice bathroomDevice) {
        ConnectSql connectSql = new ConnectSql();
        try {
            logger.info("BATHROOM_DEVICE_DB:Start connection to database!");
            Class.forName(connectSql.getClassForName());
            Connection connection = DriverManager.getConnection(connectSql.getURL(), connectSql.getUserName(), connectSql.getPassWord());
            logger.info("BATHROOM_DEVICE_DB: Good connection!");
            logger.info("BATHROOM_DEVICE_DB: Start selection!");
            String sql = "INSERT INTO bathroom_device (id_bathroom_device, bathroom_name, bathroom_powerSize_kW, bathroom_powerON, bathroom_waterProof) Values (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bathroomDevice.getId());
            preparedStatement.setString(2, bathroomDevice.getName());
            preparedStatement.setInt(3, bathroomDevice.getPowerSizekW());
            preparedStatement.setBoolean(4, bathroomDevice.isPowerON());
            preparedStatement.setBoolean(5, bathroomDevice.isWaterproof());
            return preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("BATHROOM_DEVICE_DB: Good selection!");
        return 0;
    }

    public static int update(BathroomDevice bathroomDevice) {
        ConnectSql connectSql = new ConnectSql();
        try {
            logger.info("BATHROOM_DEVICE_DB:Start connection to database!");
            Class.forName(connectSql.getClassForName());
            Connection connection = DriverManager.getConnection(connectSql.getURL(), connectSql.getUserName(), connectSql.getPassWord());
            logger.info("BATHROOM_DEVICE_DB: Good connection!");
            logger.info("BATHROOM_DEVICE_DB: Start selection!");
            String sql = "UPDATE bathroom_device SET bathroom_name=?, bathroom_powerSize_kW=?, bathroom_powerON=?, bathroom_waterProof=? WHERE id_bathroom_device=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bathroomDevice.getName());
            preparedStatement.setInt(2, bathroomDevice.getPowerSizekW());
            preparedStatement.setBoolean(3, bathroomDevice.isPowerON());
            preparedStatement.setBoolean(4, bathroomDevice.isWaterproof());
            preparedStatement.setInt(5, bathroomDevice.getId());
            return preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("BATHROOM_DEVICE_DB: Good selection!");
        return 0;
    }

    public static int delete(int id_bathroom_device) {
        ConnectSql connectSql = new ConnectSql();
        try {
            logger.info("BATHROOM_DEVICE_DB:Start connection to database!");
            Class.forName(connectSql.getClassForName());
            Connection connection = DriverManager.getConnection(connectSql.getURL(), connectSql.getUserName(), connectSql.getPassWord());
            logger.info("BATHROOM_DEVICE_DB: Good connection!");
            logger.info("BATHROOM_DEVICE_DB: Start selection!");
            String sql = "DELETE FROM bathroom_device WHERE id_bathroom_device=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_bathroom_device);
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


