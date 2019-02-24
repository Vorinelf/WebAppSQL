package com.artem.connect;

import org.apache.log4j.Logger;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool<T> {
    private static org.apache.log4j.Logger logger = Logger.getLogger(ConnectionPool.class);
    private String URL = "jdbc:mysql://localhost:3306/devices?useSSL=false";
    private String userName = "root";
    private String passWord = "root";
    private BlockingQueue<T> connectionQueue;
    private static ConnectionPool<ProxyConnection>  connectionPool= null;

    public static  ConnectionPool getConnectionPool() {
        return connectionPool = connectionPool == null ? new ConnectionPool<>(20) : connectionPool;
    }


    public ConnectionPool(final int POOL_SIZE) {
        logger.info("CONNECTION_POOL: Start method <ConnectionPool>");
        connectionQueue = new ArrayBlockingQueue<T>(POOL_SIZE);
        for (int i = 0; i < POOL_SIZE; i++) {
            T connection = null;
            try {
                connection = (T) DriverManager.getConnection(URL, userName, passWord);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connectionQueue.offer(connection);
        }
        logger.info("CONNECTION_POOL: The method <ConnectionPool> is done successfully");
    }

    public T getConnection()  {
        logger.info("CONNECTION_POOL: Start method <getConnection>");
        T connection = null;
        try {
            connection = connectionQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("CONNECTION_POOL: The method <getConnection> is done successfully");
        return connection;
    }

    public void returnConnection(T connection) {
        logger.info("CONNECTION_POOL: Start method <closeConnection>");
        connectionQueue.offer(connection);
        logger.info("CONNECTION_POOL: The method <closeConnection> is done successfully");
    }
}