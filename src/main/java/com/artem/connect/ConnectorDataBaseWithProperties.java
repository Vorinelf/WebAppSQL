package com.artem.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectorDataBaseWithProperties {
    public Connection getConnectionWithProperties () throws SQLException{
        String url = "jdbc:mysql://localhost:3306/devices?useSSL=false";
        Properties properties = new Properties();
        properties.put("user","root");
        properties.put("password","root");
        properties.put("autoReconnect","true");
        properties.put("characterEncoding","UTF-8");
        properties.put("useUnicode", "true");
        return DriverManager.getConnection(url,properties);

    }

}
