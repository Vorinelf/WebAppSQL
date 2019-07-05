package com.artem.dao;

import com.artem.users.User;

import java.util.List;

public interface DaoUser<T extends User> {

    boolean registration(User entity);

    T checkLoginOrNewUser(String login, String password);

    List<T> findAllUsers();

    boolean deleteUser(int id);

}
