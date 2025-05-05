package com.shop.dao;

//import com.shop.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    List<T> getAll();

    List<T> getAllWithName(String name);

    Optional<T> get(int id);

    boolean insert(T t);

    boolean update(T t, int id);

    boolean delete(int id);
}
