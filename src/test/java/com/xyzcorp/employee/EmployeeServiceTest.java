package com.xyzcorp.employee;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class EmployeeServiceTest {
    @Test
    public void integrationTestWiringAllComponentsManually() throws SQLException {
        Connection connection = DriverManager.getConnection
                ("jdbc:hsqldb:hsql://localhost:9001/mydb",
                        "SA", "");
        EmployeeDAO employeeDAO = new EmployeeDAO(connection);
        EmployeeService employeeService = new EmployeeService(employeeDAO);
        employeeService.hireEmployee(new Employee("Jorge", "Gomez"));

        connection.close();
    }
}