package com.artem.device;

import com.artem.connect.ConnectSql;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

public class KitchenDeviceDB {
    private static org.apache.log4j.Logger logger = Logger.getLogger(KitchenDeviceDB.class);
    ConnectSql connectSql = new ConnectSql();

    public void selectKitchenDevice() {
        logger.info("KITCHEN_DEVICE_DB: Start method <selectKitchenDevice>");

        ArrayList<KitchenDevice> kitchenDevices = new ArrayList<KitchenDevice>();

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

                KitchenDevice kitchenDevice = new KitchenDevice(name,powerSize,powerON,minT,maxT);
                System.out.println(kitchenDevice);
              //  System.out.printf("id: %d, name: %s, powerON: %s, waterProof: %s %n", id, name,powerSize, powerON, minT,maxT);
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


//        public static KitchenDevice selectOneKitchenDevice (int id_kitchen_device){
//
//            KitchenDevice kitchenDevice = null;
//            try {
//                logger.info("KITCHEN_DEVICE_DB:Start connection to database!");
//                Class.forName(connectSql.getClassForName());
//                Connection connection = DriverManager.getConnection(connectSql.getURL(), connectSql.getUserName(), connectSql.getPassWord());
//                logger.info("KITCHEN_DEVICE_DB: Good connection!");
//
//
//                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products WHERE id_kitchen_device=?;")
//                    preparedStatement.setInt(1, id_kitchen_device);
//                    ResultSet resultSet = preparedStatement.executeQuery();
//                    if (resultSet.next()) {
//
//                        int Id = resultSet.getInt(1);
//                        String name = resultSet.getString(2);
//                        int price = resultSet.getInt(3);
//                        kitchenDevice = new KitchenDevice();
//                    }
//
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        } catch(Exception ex){
//            System.out.println(ex);
//        }
//        return product;
//    }
//
//    public static int insert(Product product) {
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
//            try (Connection conn = DriverManager.getConnection(url, username, password)) {
//
//                String sql = "INSERT INTO products (name, price) Values (?, ?)";
//                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
//                    preparedStatement.setString(1, product.getName());
//                    preparedStatement.setInt(2, product.getPrice());
//
//                    return preparedStatement.executeUpdate();
//                }
//            }
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
//        return 0;
//    }
//
//    public static int update(Product product) {
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
//            try (Connection conn = DriverManager.getConnection(url, username, password)) {
//
//                String sql = "UPDATE products SET name = ?, price = ? WHERE id = ?";
//                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
//                    preparedStatement.setString(1, product.getName());
//                    preparedStatement.setInt(2, product.getPrice());
//                    preparedStatement.setInt(3, product.getId());
//
//                    return preparedStatement.executeUpdate();
//                }
//            }
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
//        return 0;
//    }
//
//    public static int delete(int id) {
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
//            try (Connection conn = DriverManager.getConnection(url, username, password)) {
//
//                String sql = "DELETE FROM products WHERE id = ?";
//                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
//                    preparedStatement.setInt(1, id);
//
//                    return preparedStatement.executeUpdate();
//                }
//            }
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
//        return 0;
    }
}

