package com.capgemini.jpa.service;

import java.util.List;

import com.capgemini.jpa.dao.EmployeeDaoImpl;
import com.capgemini.jpa.dao.IEmployeeDAO;
import com.capgemini.jpa.entity.Employee;
import com.capgemini.jpa.exception.EmployeeException;

public class EmployeeServiceImpl implements IEmployeeService {
	private IEmployeeDAO employeeDAO=new EmployeeDaoImpl();
	
	@Override
	public void addNewEmployee(Employee employee) throws EmployeeException {
		employeeDAO.addNewEmployee(employee);
		
	}

	@Override
	public void deleteEmployee(Integer empid) throws EmployeeException {
		employeeDAO.deleteEmployee(empid);
		
	}

	@Override
	public void updateEmployee(Employee employee) throws EmployeeException {
		employeeDAO.updateEmployee(employee);
		
	}

	@Override
	public Employee getEmployeeDetails(Integer empid) throws EmployeeException {
		
		return employeeDAO.getEmployeeDetails(empid);
	}

	@Override
	public List<Employee> getAllEmployees() throws EmployeeException {
		
		return employeeDAO.getAllEmployees();
	}

}
