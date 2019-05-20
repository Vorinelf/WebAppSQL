package com.artem.db;

import com.artem.connect.ConnectionPoolNew;
import com.artem.connect.ProxyConnection;
import com.artem.device.BathroomDevice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper {
    private final static String SQL_INSERT = "INSERT INTO bathroom_device (id_bathroom_device, bathroom_name, bathroom_powerSize_kW, bathroom_powerON, bathroom_waterProof) Values (?,?,?,?,?)";

    private final static String SQL_SELECTALL = "select * from bathroom_device";






    Connection connection;

    public Connection getConnection() {
        return connection;
    }



    public DataBaseHelper() {
        connection = ConnectionPoolNew.getInstance().getConnection();
    }


    public PreparedStatement getPrepareStatementInsert() {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL_INSERT);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    public Statement getStatementSelectAll() {
        Statement st = null;
        try {
            st = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return st;
    }

    public List<BathroomDevice> selectAllBathroomDevice(Statement ps) {
        List<BathroomDevice> bathroomDevicesArray = new ArrayList();
        try {
            ResultSet rs = ps.executeQuery(SQL_SELECTALL);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int powerSize = rs.getInt(3);
                boolean powerON = rs.getBoolean(4);
                boolean waterproof = rs.getBoolean(5);
                BathroomDevice bathroomDevice = new BathroomDevice(id, name, powerSize, powerON, waterproof);
                bathroomDevicesArray.add(bathroomDevice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bathroomDevicesArray;
    }

    public boolean insertBathroomDevice(PreparedStatement psi, BathroomDevice bathroomDevice) {
        boolean flag = false;
        try {
            psi.setInt(1, bathroomDevice.getId());
            psi.setString(2, bathroomDevice.getName());
            psi.setInt(3, bathroomDevice.getPowerSizekW());
            psi.setBoolean(4, bathroomDevice.isPowerON());
            psi.setBoolean(5, bathroomDevice.isWaterproof());
            psi.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;

    }


    public void closePrepareStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



    public void closeStatement(Statement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void closeConnect() {
        if (getConnection() != null) ConnectionPoolNew.getInstance().closeConnection(getConnection());
    }

}
