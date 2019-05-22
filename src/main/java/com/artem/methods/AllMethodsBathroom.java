package com.artem.methods;

import com.artem.dao.Dao;
import com.artem.device.BathroomDevice;
import com.artem.device.Device;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AllMethodsBathroom implements Dao <Device> {
    @Override
    public List<Device> findAll() {
        List<BathroomDevice> bathroomDevicesArray = new ArrayList();
        try {
            ResultSet rs = ps.executeQuery("select * from bathroom_device");
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int powerSize = rs.getInt(3);
                boolean powerON = rs.getBoolean(4);
                boolean waterproof = rs.getBoolean(5);
                BathroomDevice bathroomDevice = new BathroomDevice(id, name, powerSize, powerON, waterproof);
                bathroomDevicesArray.add(bathroomDevice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bathroomDevicesArray;
    }
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Device entity) {

    }

    @Override
    public void save(Device entity) {

    }

    @Override
    public Device findEntityById(int id) {
        return null;
    }
}
