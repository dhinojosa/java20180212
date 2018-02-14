package com.xyzcorp.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDAO {

    private final Connection connection;

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
