package com.xyzcorp.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class EmployeeDAO {

    private final Connection connection;

    @Autowired
    public EmployeeDAO(Connection connection) {
        this.connection = connection;
    }

    public void persist(Employee employee) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement
                    ("INSERT INTO Employee (firstName, lastName) values (?,?)")) {
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.execute();
        }
    }
}
