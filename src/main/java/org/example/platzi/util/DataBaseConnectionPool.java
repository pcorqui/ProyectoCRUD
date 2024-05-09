package org.example.platzi.util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnectionPool {

    static final String user = "root";
    static final String pass = "admin";
    static final String url = "jdbc:mysql://localhost:3306/project";
    static BasicDataSource pool = null;

    public static BasicDataSource getInstance() throws SQLException {
        if (pool == null) {
            pool = new BasicDataSource();
            pool.setUrl(url);
            pool.setUsername(user);
            pool.setPassword(pass);

            //indica el tamanio inicial del pool de conexiones
            pool.setInitialSize(3);
            //configura el minimo de conexiones inactivas que se pueden mantener
            pool.setMinIdle(2);
            //establece el numero maximo de conexiones inactivas que se puede mantener
            pool.setMaxIdle(10);
            //El numero de conexiones totales que el pool puede mantener activa simultaneamente
            pool.setMaxTotal(10);

        }

        return pool;
    }

    public static Connection getConnetion() throws SQLException {
        return getInstance().getConnection();
    }
}
