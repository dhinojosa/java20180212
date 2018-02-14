package com.xyzcorp.employee;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EmployeeDAOTest {

    @Test
    public void testPersist() throws SQLException {

        //100.45.128.183

        Connection connection = DriverManager.getConnection
                ("jdbc:hsqldb:hsql://localhost:9001/mydb",
                "SA", "");
        EmployeeDAO employeeDAO = new EmployeeDAO(connection);
        employeeDAO.persist(new Employee("Chris", "Mattera"));
        connection.close();
    }
}
