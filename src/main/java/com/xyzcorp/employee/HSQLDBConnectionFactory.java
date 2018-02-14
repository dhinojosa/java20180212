package com.xyzcorp.employee;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class HSQLDBConnectionFactory {

    @Bean
    public static Connection create() throws SQLException {
        Connection connection = DriverManager.getConnection
                ("jdbc:hsqldb:hsql://localhost:9001/mydb",
                        "SA", "");
        return connection;
    }
}
