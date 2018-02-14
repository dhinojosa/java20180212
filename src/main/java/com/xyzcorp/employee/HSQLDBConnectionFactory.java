package com.xyzcorp.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HSQLDBConnectionFactory {

    public static Connection create() throws SQLException {
        Connection connection = DriverManager.getConnection
                ("jdbc:hsqldb:hsql://localhost:9001/mydb",
                        "SA", "");
        return connection;
    }
}
