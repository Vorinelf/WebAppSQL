package com.artem.device;

public abstract class Device {
    private int id;
    private String name;
    private int powerSizekW;
    private boolean powerON;


    public Device(int id, String name, int powerSizekW, boolean powerON) {
        this.id = id;
        this.name = name;
        this.powerSizekW = powerSizekW;
        this.powerON = powerON;

    }


    public Device() {
    }

    @Override
    public String toString() {
        return "Id" + getId() + "Name: " + getName() + " " + "PowerSize: " + getPowerSizekW() + " " + "PowerON: " + isPowerON();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPowerSizekW(int powerSizekW) {
        this.powerSizekW = powerSizekW;
    }

    public void setPowerON(boolean powerON) {
        this.powerON = powerON;
    }

    public String getName() {
        return name;
    }

    public int getPowerSizekW() {
        return powerSizekW;
    }

    public boolean isPowerON() {
        return powerON;
    }


}

