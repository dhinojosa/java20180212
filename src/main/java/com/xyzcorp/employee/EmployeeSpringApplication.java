package com.xyzcorp.employee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

@ComponentScan
public class EmployeeSpringApplication {
    public static void main(String[] args) throws SQLException {
        ApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("/beans.xml");

        EmployeeService employeeService = applicationContext.getBean
                ("employeeService", EmployeeService.class);

        employeeService.hireEmployee(new Employee("Artiom", "Bell"));
    }
}
