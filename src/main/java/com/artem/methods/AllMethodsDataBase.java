package com.artem.methods;

import com.artem.connect.ConnectionPoolNew;
import com.artem.dao.Dao;
import com.artem.headphones.Headphones;
import com.artem.users.User;


import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AllMethodsDataBase implements Dao<Headphones> {
    private final static AllMethodsDataBase INSTANCE = new AllMethodsDataBase();
    private List<Headphones> headphonesArray;
    private AtomicInteger idGenerator;

    private AllMethodsDataBase() {
    }

    public static AllMethodsDataBase getInstance() {
        return INSTANCE;
    }


    private Connection connection = ConnectionPoolNew.getInstance().getConnection();


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

            ConnectionPoolNew.getInstance().closeConnection(connection);
        }
        return headphonesArray;
    }

    @Override
    public List<Headphones> findByName(String name) {
        List<Headphones> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT * FROM headphones WHERE name=?");
            preparedStatement.setString(1, name);
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
            ConnectionPoolNew.getInstance().closeConnection(connection);
        }
        return list;
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
            ConnectionPoolNew.getInstance().closeConnection(connection);
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
            ConnectionPoolNew.getInstance().closeConnection(connection);
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
            ConnectionPoolNew.getInstance().closeConnection(connection);
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
            ConnectionPoolNew.getInstance().closeConnection(connection);
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
            ConnectionPoolNew.getInstance().closeConnection(connection);
        }
        return list;
    }

    @Override
    public List<Headphones> findByConstruction(String construct) {
        List<Headphones> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT * FROM headphones WHERE construction=?");
            preparedStatement.setString(1, construct);
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
            ConnectionPoolNew.getInstance().closeConnection(connection);
        }
        return list;
    }

    @Override
    public List<Headphones> findByHiRes(String hiRes) {
        List<Headphones> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT * FROM headphones WHERE hiRes=?");
            preparedStatement.setString(1, hiRes);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String model = resultSet.getString(3);
                int price = resultSet.getInt(4);
                String construction = resultSet.getString(5);
                String hiRes1 = resultSet.getString(6);
                String bluetooth = resultSet.getString(7);
                int release = resultSet.getInt(8);
                String stock = resultSet.getString(9);
                Headphones headphones = new Headphones(id, name, model, price, construction, hiRes1, bluetooth, release, stock);
                list.add(headphones);
            }
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPoolNew.getInstance().closeConnection(connection);
        }
        return list;
    }

    @Override
    public List<Headphones> findByBlue(String blue) {
        List<Headphones> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT * FROM headphones WHERE bluetooth=?");
            preparedStatement.setString(1, blue);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String model = resultSet.getString(3);
                int price = resultSet.getInt(4);
                String construction = resultSet.getString(5);
                String hiRes1 = resultSet.getString(6);
                String bluetooth = resultSet.getString(7);
                int release = resultSet.getInt(8);
                String stock = resultSet.getString(9);
                Headphones headphones = new Headphones(id, name, model, price, construction, hiRes1, bluetooth, release, stock);
                list.add(headphones);
            }
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPoolNew.getInstance().closeConnection(connection);
        }
        return list;
    }

    @Override
    public List<Headphones> findByStock(String stock) {
        List<Headphones> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT * FROM headphones WHERE stock=?");
            preparedStatement.setString(1, stock);
            ResultSet resultSet = preparedStatement.executeQuery();
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
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPoolNew.getInstance().closeConnection(connection);
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
            ConnectionPoolNew.getInstance().closeConnection(connection);
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
            ConnectionPoolNew.getInstance().closeConnection(connection);
        }
        return list;
    }

    @Override
    public boolean saveOrderInBase(List<Headphones> listHeadphones, User user) {
        boolean flag = false;
        Date date = new Date();
        try {
            for (Headphones hd : listHeadphones) {
                PreparedStatement preparedStatement = connection.prepareStatement
                        ("INSERT INTO orders (dateOrder, firstName, secondName, brand, model, price, country, city, street, postIndex, phone) Values (?,?,?,?,?,?,?,?,?,?,?)");
                preparedStatement.setString(1, date.toString());
                preparedStatement.setString(2, user.getFirstName());
                preparedStatement.setString(3, user.getSecondName());
                preparedStatement.setString(4, hd.getName());
                preparedStatement.setString(5, hd.getModel());
                preparedStatement.setInt(6, hd.getPrice());
                preparedStatement.setString(7, user.getCountry());
                preparedStatement.setString(8, user.getCity());
                preparedStatement.setString(9, user.getStreet());
                preparedStatement.setString(10, user.getPostIndex());
                preparedStatement.setString(11, user.getPhone());
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            flag = true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPoolNew.getInstance().closeConnection(connection);
        }
        return flag;
    }
}
