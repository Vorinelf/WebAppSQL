package com.artem.connect;

import com.artem.device.Device;

import java.util.List;

public abstract class AbstractDAO <K,T extends Device> {
    public abstract List<T> findAll();
    public abstract T findEntityById (K id);
    public abstract boolean delete (K id);
    public abstract boolean delete (T device);
    public abstract boolean create (T device);
    public abstract T update (T device);
 }
