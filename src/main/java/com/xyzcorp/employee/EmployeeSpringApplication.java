package com.xyzcorp.employee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class EmployeeSpringApplication {
    public static void main(String[] args) throws SQLException {
        ApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("/beans.xml");

        EmployeeService employeeService = applicationContext.getBean
                ("employeeService", EmployeeService.class);

        employeeService.hireEmployee(new Employee("Angel", "Arce"));
    }
}
