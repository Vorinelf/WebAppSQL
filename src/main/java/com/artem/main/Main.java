package com.artem.main;

import com.artem.db.KitchenDeviceDB;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
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
        KitchenDeviceDB kitchenDeviceDB =  KitchenDeviceDB.getBathroomDeviceDB();
      kitchenDeviceDB.selectKitchenDevice();
      // kitchenDeviceDB.selectOneKitchenDevice(5);
     //   kitchenDeviceDB.insert(new KitchenDevice(4,"bbbb",5,true,5,  5));
        // kitchenDeviceDB.update(new KitchenDevice(4,"cccc",5,true,5,  5));


    }
}
