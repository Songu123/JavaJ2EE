
package com.shop.dao;

import com.shop.util.Constant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static DBConnection instance = null;
    private Connection conn = null;

    private DBConnection() {
    }

    private void init() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(Constant.DB_URL, Constant.USER, Constant.PASS);
            System.out.println("Connected to database!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public static DBConnection getInstance() throws SQLException {
        if (instance != null && !instance.getConnection().isClosed()) {
            return instance;
        } else {
            instance = new DBConnection();
            instance.init();
        }
        return instance;
    }
}
