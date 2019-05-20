package com.artem.connect;


import java.sql.Connection;
import java.sql.DriverManager;

public class SimpleJdbcRunner {
    private String URL = "jdbc:mysql://localhost:3306/devices?useSSL=false";
    private String userName = "root";
    private String passWord = "root";

    Connection connection = null;


}
