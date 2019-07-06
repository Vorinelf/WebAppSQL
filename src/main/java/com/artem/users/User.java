package com.artem.users;




public class User {

    private String isAdmin,login, password, firstName, secondName, country, city, street, postIndex, phone;
    private int id;

    public User(int id, String isAdmin, String login, String password, String firstName, String secondName, String country, String city, String street, String postIndex, String phone) {
        this.isAdmin = isAdmin;
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.secondName = secondName;
        this.country = country;
        this.city = city;
        this.street = street;
        this.postIndex = postIndex;
        this.phone = phone;
        this.id = id;
    }

    public User(String isAdmin, String login, String password, String firstName, String secondName, String country, String city, String street, String postIndex, String phone) {
        this.isAdmin = isAdmin;
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.secondName = secondName;
        this.country = country;
        this.city = city;
        this.street = street;
        this.postIndex = postIndex;
        this.phone = phone;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostIndex() {
        return postIndex;
    }

    public void setPostIndex(String postIndex) {
        this.postIndex = postIndex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
