package com.tss.Service;

import java.util.List;

import com.tss.DAO.EmployeeDAO;
import com.tss.model.Employee;

public class EmployeeService {
    private EmployeeDAO dao = new EmployeeDAO();

    public List<Employee> fetchAllEmployees() {
        return dao.getAllEmployees();
    }
}
