package com.artem.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class ConnectorDataBaseWithResourcesFile {


    public Connection getConnect() throws SQLException {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("devices");
        String url = resourceBundle.getString("db.url");
        String user = resourceBundle.getString("db.user");
        String password = resourceBundle.getString("db.password");
        String useUnicode = resourceBundle.getString("db.useUnicode");
        String encoding = resourceBundle.getString("db.encoding");

        DriverManager.registerDriver(new com.mysql.jdbc.Driver());


        return DriverManager.getConnection(url, user, password);
    }

}
