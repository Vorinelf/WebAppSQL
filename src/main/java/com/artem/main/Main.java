package com.artem.main;

import com.artem.connect.ConnectSql;
import com.artem.device.KitchenDeviceDB;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    private static org.apache.log4j.Logger logger = Logger.getLogger(Main.class);
    private static Connection connection;
    private static Statement stmt;
    private static ResultSet rs;

    public static void main(String[] args) {
        String query = "select * from bathroom_device";
        String query1 = "select * from help_category where parent_category_id=7";
        String query2 = "INSERT INTO mysql.help_category (help_category_id, name, parent_category_id, url  ) VALUES (41, 'Mike', 7, 'url')";
        String query3 = "select count(*) from help_category";
        KitchenDeviceDB kitchenDeviceDB = new KitchenDeviceDB();
        kitchenDeviceDB.selectKitchenDevice();
//        try {
//            logger.info("Start connection to database!");
//            Class.forName(connectSql.getClassForName());
//            connection = DriverManager.getConnection(connectSql.getURL(), connectSql.getUserName(), connectSql.getPassWord());
//            logger.info("Good connection!");
//            stmt = connection.createStatement();
//            //  stmt.executeUpdate(query2);
//            logger.info("Start selection!");
//            rs = stmt.executeQuery(query);
//
//            while (rs.next()) {
//                int id = rs.getInt(1);
//                //    int count = rs.getInt(1);
//                // logger.info(id);
//                String name = rs.getString(2);
//                int powerON = rs.getInt(3);
//                int waterProof = rs.getInt(4);
//                System.out.printf("id: %d, name: %s, powerON: %s, waterProof: %s %n", id, name, powerON, waterProof);
//            }
//
//            if (connection != null) {
//                connection.close();
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        logger.info("Good selection!");

    }
}
