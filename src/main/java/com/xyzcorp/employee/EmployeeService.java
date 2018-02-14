package com.xyzcorp.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public void hireEmployee(Employee employee) throws SQLException {
       if (employee == null)
           throw new NullPointerException("Employee was null");
       if (employee.getFirstName().isEmpty())
           throw new IllegalArgumentException
                   ("First Name cannot be blank");
        if (employee.getLastName().isEmpty())
            throw new IllegalArgumentException
                    ("Last Name cannot be blank");
       this.employeeDAO.persist(employee);
    }
}
