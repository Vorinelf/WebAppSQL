package com.artem.methods;

import com.artem.connect.ConnectionPool;
import com.artem.dao.DaoHeadphones;
import com.artem.headphones.Headphones;
import com.artem.users.User;


import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class HeadphonesMethods implements DaoHeadphones<Headphones> {
    private final static HeadphonesMethods INSTANCE = new HeadphonesMethods();
    private List<Headphones> headphonesArray;
    private AtomicInteger idGenerator;

    private HeadphonesMethods() {
    }

    public static HeadphonesMethods getInstance() {
        return INSTANCE;
    }


    private Connection connection = ConnectionPool.getInstance().getConnection();


    @Override
    public List<Headphones> findAll() {
        headphonesArray = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM headphones");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String model = resultSet.getString(3);
                int price = resultSet.getInt(4);
                String construction = resultSet.getString(5);
                String hiRes = resultSet.getString(6);
                String bluetooth = resultSet.getString(7);
                int release = resultSet.getInt(8);
                String stock = resultSet.getString(9);
                Headphones headphones = new Headphones(id, name, model, price, construction, hiRes, bluetooth, release, stock);
                headphonesArray.add(headphones);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            ConnectionPool.getInstance().closeConnection(connection);
        }
        return headphonesArray;
    }


    @Override
    public Headphones findEntityById(int id) {
        Headphones headphones = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT * FROM headphones WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id1 = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String model = resultSet.getString(3);
                int price = resultSet.getInt(4);
                String construction = resultSet.getString(5);
                String hiRes = resultSet.getString(6);
                String bluetooth = resultSet.getString(7);
                int release = resultSet.getInt(8);
                String stock = resultSet.getString(9);
                headphones = new Headphones(id1, name, model, price, construction, hiRes, bluetooth, release, stock);
            }
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().closeConnection(connection);
        }
        return headphones;
    }

    @Override
    public boolean delete(int id) {
        boolean flag = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("DELETE FROM headphones WHERE id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            flag = true;
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().closeConnection(connection);
        }
        return flag;

    }

    @Override
    public boolean update(Headphones headphones) {
        boolean flag = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("UPDATE headphones SET name=?, model=?, price=?, construction=?, hiRes=?, bluetooth=?, releas=?, stock=? WHERE id=?");
            preparedStatement.setString(1, headphones.getName());
            preparedStatement.setString(2, headphones.getModel());
            preparedStatement.setInt(3, headphones.getPrice());
            preparedStatement.setString(4, headphones.getConstruction());
            preparedStatement.setString(5, headphones.getHiRes());
            preparedStatement.setString(6, headphones.getBluetooth());
            preparedStatement.setInt(7, headphones.getRelease());
            preparedStatement.setString(8, headphones.getStock());
            preparedStatement.setInt(9, headphones.getId());
            preparedStatement.executeUpdate();
            flag = true;
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().closeConnection(connection);
        }

        return flag;
    }

    @Override
    public boolean create(Headphones headphones) {
        boolean flag = false;
        idGenerator = new AtomicInteger(headphonesArray.size());
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("INSERT INTO headphones (name, model, price, construction, hiRes, bluetooth, releas, stock) Values (?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, headphones.getName());
            preparedStatement.setString(2, headphones.getModel());
            preparedStatement.setInt(3, headphones.getPrice());
            preparedStatement.setString(4, headphones.getConstruction());
            preparedStatement.setString(5, headphones.getHiRes());
            preparedStatement.setString(6, headphones.getBluetooth());
            preparedStatement.setInt(7, headphones.getRelease());
            preparedStatement.setString(8, headphones.getStock());
            preparedStatement.executeUpdate();
            flag = true;
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().closeConnection(connection);
        }
        return flag;
    }

    @Override
    public List<Headphones> findByPrice(int priceFrom, int priceTo) {
        List<Headphones> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    (" SELECT * FROM headphones WHERE price BETWEEN ? AND ?");
            preparedStatement.setInt(1, priceFrom);
            preparedStatement.setInt(2, priceTo);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name1 = resultSet.getString(2);
                String model = resultSet.getString(3);
                int price = resultSet.getInt(4);
                String construction = resultSet.getString(5);
                String hiRes = resultSet.getString(6);
                String bluetooth = resultSet.getString(7);
                int release = resultSet.getInt(8);
                String stock = resultSet.getString(9);
                Headphones headphones = new Headphones(id, name1, model, price, construction, hiRes, bluetooth, release, stock);
                list.add(headphones);
            }
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().closeConnection(connection);
        }
        return list;
    }

    @Override
    public List<Headphones> findAndSortByPrice(String column, String highOrLow) {
        List<Headphones> list = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM headphones ORDER BY " + column + " " + highOrLow);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name1 = resultSet.getString(2);
                String model = resultSet.getString(3);
                int price = resultSet.getInt(4);
                String construction = resultSet.getString(5);
                String hiRes = resultSet.getString(6);
                String bluetooth = resultSet.getString(7);
                int release = resultSet.getInt(8);
                String stock = resultSet.getString(9);
                Headphones headphones = new Headphones(id, name1, model, price, construction, hiRes, bluetooth, release, stock);
                list.add(headphones);
            }
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().closeConnection(connection);
        }
        return list;
    }

    @Override
    public List<Headphones> findAndSortBy(String column) {
        List<Headphones> list = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM headphones ORDER BY " + column);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name1 = resultSet.getString(2);
                String model = resultSet.getString(3);
                int price = resultSet.getInt(4);
                String construction = resultSet.getString(5);
                String hiRes = resultSet.getString(6);
                String bluetooth = resultSet.getString(7);
                int release = resultSet.getInt(8);
                String stock = resultSet.getString(9);
                Headphones headphones = new Headphones(id, name1, model, price, construction, hiRes, bluetooth, release, stock);
                list.add(headphones);
            }
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().closeConnection(connection);
        }
        return list;
    }


    @Override
    public List<Headphones> findBy(String column, String param) {
        List<Headphones> list = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM headphones WHERE " + column + "=" + param);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String mode = resultSet.getString(3);
                int price = resultSet.getInt(4);
                String construction = resultSet.getString(5);
                String hiRes = resultSet.getString(6);
                String bluetooth = resultSet.getString(7);
                int release = resultSet.getInt(8);
                String stock1 = resultSet.getString(9);
                Headphones headphones = new Headphones(id, name, mode, price, construction, hiRes, bluetooth, release, stock1);
                list.add(headphones);
            }
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().closeConnection(connection);
        }
        return list;
    }

}
