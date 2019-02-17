package com.artem.device;


public class BathroomDevice extends Device {
    private boolean waterproof;

    public void setWaterproof(boolean waterproof) {
        this.waterproof = waterproof;
    }

    public BathroomDevice() {
    }

    public BathroomDevice(int id, String name, int powerSizekW, boolean powerON, boolean waterproof) {
        super(id, name, powerSizekW, powerON);

        this.waterproof = waterproof;
    }

    @Override
    public String toString() {
        return "Id" + getId() + "Name: " + getName() + " " + "PowerSize: " + getPowerSizekW()
                + " " + "PowerON: " + isPowerON() + " " + "waterproof: " + isWaterproof();
    }

    public boolean isWaterproof() {
        return waterproof;
    }
}

