package com.artem.db;

import com.artem.connect.ConnectionPool;
import com.artem.device.BathroomDevice;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BathroomDeviceDB {
    private static org.apache.log4j.Logger logger = Logger.getLogger(BathroomDeviceDB.class);

    private static BathroomDeviceDB bathroomDeviceDB = new BathroomDeviceDB();

    private BathroomDeviceDB() {
    }


    public static BathroomDeviceDB getBathroomDeviceDB() {
        return bathroomDeviceDB;
    }

    public List<BathroomDevice> selectBatroomDevice() {
        logger.info("BATHROOM_DEVICE_DB: Start method <selectBathroomDevice>");

        List<BathroomDevice> bathroomDevicesArray = new ArrayList<BathroomDevice>();
        try {
            Connection connection = (Connection) ConnectionPool.getInstance().getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from bathroom_device");
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int powerSize = rs.getInt(3);
                boolean powerON = rs.getBoolean(4);
                boolean waterproof = rs.getBoolean(5);
                BathroomDevice bathroomDevice = new BathroomDevice(id, name, powerSize, powerON, waterproof);
                bathroomDevicesArray.add(bathroomDevice);
                ConnectionPool.getInstance().returnConnection(connection);
            }
            if (stmt != null && rs != null) {
                stmt.close();
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("BATHROOM_DEVICE_DB: The method <selectBathroomDevice> is done successfully");
        return bathroomDevicesArray;
    }


    public BathroomDevice selectOneBathroomDevice(int id_bathroom_device) {
        logger.info("BATHROOM_DEVICE_DB: Start method <selectOneBathroomDevice>");
        BathroomDevice bathroomDevice = null;
        try {
            Connection connection = (Connection) ConnectionPool.getInstance().getConnection();
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
                ConnectionPool.getInstance().returnConnection(connection);
            }
            if (preparedStatement != null && rs != null) {
                preparedStatement.close();
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("BATHROOM_DEVICE_DB: The method <selectOneBathroomDevice> is done successfully");
        return bathroomDevice;
    }

    public int insert(BathroomDevice bathroomDevice) {
        try {
            logger.info("BATHROOM_DEVICE_DB: Start method <insert>");
            Connection connection = (Connection) ConnectionPool.getInstance().getConnection();
            String sql = "INSERT INTO bathroom_device (id_bathroom_device, bathroom_name, bathroom_powerSize_kW, bathroom_powerON, bathroom_waterProof) Values (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bathroomDevice.getId());
            preparedStatement.setString(2, bathroomDevice.getName());
            preparedStatement.setInt(3, bathroomDevice.getPowerSizekW());
            preparedStatement.setBoolean(4, bathroomDevice.isPowerON());
            preparedStatement.setBoolean(5, bathroomDevice.isWaterproof());
            ConnectionPool.getInstance().returnConnection(connection);
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("BATHROOM_DEVICE_DB: The method <insert> is done successfully");
        return 0;
    }

    public int update(BathroomDevice bathroomDevice) {
        try {
            logger.info("BATHROOM_DEVICE_DB: Start method <update>");
            Connection connection = (Connection) ConnectionPool.getInstance().getConnection();
            String sql = "UPDATE bathroom_device SET bathroom_name=?, bathroom_powerSize_kW=?, bathroom_powerON=?, bathroom_waterProof=? WHERE id_bathroom_device=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bathroomDevice.getName());
            preparedStatement.setInt(2, bathroomDevice.getPowerSizekW());
            preparedStatement.setBoolean(3, bathroomDevice.isPowerON());
            preparedStatement.setBoolean(4, bathroomDevice.isWaterproof());
            preparedStatement.setInt(5, bathroomDevice.getId());
            ConnectionPool.getInstance().returnConnection(connection);
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("BATHROOM_DEVICE_DB: The method <update> is done successfully");
        return 0;
    }

    public int delete(int id_bathroom_device) {

        try {
            Connection connection = (Connection) ConnectionPool.getInstance().getConnection();
            logger.info("BATHROOM_DEVICE_DB: Start method <delete>");
            String sql = "DELETE FROM bathroom_device WHERE id_bathroom_device=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_bathroom_device);
            ConnectionPool.getInstance().returnConnection(connection);
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("BATHROOM_DEVICE_DB: The method <delete> is done successfully");
        return 0;
    }
}
