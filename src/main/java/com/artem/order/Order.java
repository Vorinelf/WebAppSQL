package com.artem.order;

public class Order {

   private String dateOrder, firstName, secondName, brand,
           model,  country, city, street, postIndex, phone;
   private int price, id;

    public Order(int id, String dateOrder, String firstName, String secondName, String brand, String model, int price, String country, String city, String street, String postIndex, String phone) {
        this.dateOrder = dateOrder;
        this.firstName = firstName;
        this.secondName = secondName;
        this.brand = brand;
        this.model = model;
        this.country = country;
        this.city = city;
        this.street = street;
        this.postIndex = postIndex;
        this.phone = phone;
        this.price = price;
        this.id = id;
    }

    public Order(String dateOrder, String firstName, String secondName, String brand, String model, int price, String country, String city, String street, String postIndex, String phone) {
        this.dateOrder = dateOrder;
        this.firstName = firstName;
        this.secondName = secondName;
        this.brand = brand;
        this.model = model;
        this.country = country;
        this.city = city;
        this.street = street;
        this.postIndex = postIndex;
        this.phone = phone;
        this.price = price;
    }

    public String getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

