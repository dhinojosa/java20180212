package com.xyzcorp.employee;

import org.springframework.context.annotation
        .AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.sql.SQLException;

@ComponentScan(basePackages = {"com.xyzcorp.employee"})
public class EmployeeSpringApplication {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext applicationContext = new
                AnnotationConfigApplicationContext();

        applicationContext.register(EmployeeSpringApplication.class);
        applicationContext.refresh();

        EmployeeService employeeService = applicationContext.getBean
                ("employeeService", EmployeeService.class);

        employeeService.hireEmployee(new Employee("Aaron", "Silverman"));
        employeeService.hireEmployee(new Employee("Neil", "Nguyen"));
    }
}
