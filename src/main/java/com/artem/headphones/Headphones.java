package com.artem.headphones;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class Headphones {
    private int id, price, release;
    private String name, construction, model, hiRes, bluetooth, stock;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRelease() {
        return release;
    }

    public void setRelease(int release) {
        this.release = release;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConstruction() {
        return construction;
    }

    public void setConstruction(String construction) {
        this.construction = construction;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getHiRes() {
        return hiRes;
    }

    public void setHiRes(String hiRes) {
        this.hiRes = hiRes;
    }

    public String getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public Headphones(String name, String model, int price, String construction, String hiRes, String bluetooth, int release, String stock) {
        this.price = price;
        this.release = release;
        this.name = name;
        this.model = model;
        this.construction = construction;
        this.hiRes = hiRes;
        this.bluetooth = bluetooth;
        this.stock = stock;
    }

    public Headphones(int id, String name, String model, int price, String construction, String hiRes, String bluetooth, int release, String stock) {
        this.id = id;
        this.price = price;
        this.release = release;
        this.name = name;
        this.model = model;
        this.construction = construction;
        this.hiRes = hiRes;
        this.bluetooth = bluetooth;
        this.stock = stock;
    }
}
