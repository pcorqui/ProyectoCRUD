package org.example.platzi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//usaremos singleton para esta implementacion
public class DataBaseConnection {

    static final String user = "root";
    static final String pass = "admin";
    static final String url = "jdbc:mysql://localhost:3306/project";
    static Connection connection = null;

    public static Connection getConnection() throws SQLException {
            if (connection == null)
                 connection =
                        DriverManager
                                .getConnection(
                                        url,user,pass);

        return connection;
    }

}
