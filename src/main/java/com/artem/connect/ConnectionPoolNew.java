package com.artem.connect;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPoolNew {

    private final static ConnectionPoolNew INSTANCE = new ConnectionPoolNew(20);

    public static ConnectionPoolNew getInstance() {
        return INSTANCE;
    }

    private BlockingQueue<Connection> connectionQueue;

    public ConnectionPoolNew(final int POOL_SIZE) {
        ConnectorDataBaseWithResourcesFile connectorDataBaseWithResourcesFile = new ConnectorDataBaseWithResourcesFile();
        connectionQueue = new ArrayBlockingQueue<>(POOL_SIZE);
        for (int i = 0; i < POOL_SIZE; i++) {
            ProxyConnection proxyConnection = null;
            try {
                proxyConnection = new ProxyConnection(connectorDataBaseWithResourcesFile.getConnect());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (proxyConnection != null) {
                connectionQueue.offer(proxyConnection);
            }
        }
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = connectionQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void closeConnection(Connection connection) {
        connectionQueue.offer(connection);
    }
}
