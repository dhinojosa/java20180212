package com.xyzcorp.employee;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class HSQLDBConnectionFactory {

    @Bean
    public static Connection create() throws SQLException {
        System.out.println("Connection being retrieved");
        Connection connection = DriverManager.getConnection
                ("jdbc:hsqldb:hsql://localhost:9001/mydb",
                        "SA", "");
        return connection;
    }
}
