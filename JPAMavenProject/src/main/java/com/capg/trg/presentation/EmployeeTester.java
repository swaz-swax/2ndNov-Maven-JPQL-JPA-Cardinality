package com.capg.trg.presentation;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;



import javax.persistence.criteria.CriteriaBuilder.In;

import com.capgemini.jpa.entity.Employee;
import com.capgemini.jpa.exception.EmployeeException;
import com.capgemini.jpa.service.EmployeeServiceImpl;
import com.capgemini.jpa.service.IEmployeeService;

public class EmployeeTester {
	private static IEmployeeService employeeService=
								new EmployeeServiceImpl();
	static Employee employee;

	public static void main(String[] args) 
	{
		while (true) 
		{Scanner scanner=new Scanner(System.in);
			System.out.println("\n\tMenu");
			System.out.println("1. Add an employee");
			System.out.println("2. Delete an employee");
			System.out.println("3. Update salary of an employee");
			System.out.println("4. Display an employee");
			System.out.println("5. Display all employees");
			System.out.println("6. Exit");
			
			System.out.println("\nEnter your choice: ");
			int ch=scanner.nextInt();

			switch (ch) 
			{
			case 1:
				
				System.out.println("Enter your details----");
				System.out.println("Name :");
				String name=scanner.next();
				
				System.out.println("job :");
				String job=scanner.next();
				
				System.out.println("Salary :");
				Double sal=scanner.nextDouble();
				
				System.out.println("Department no. :");
				int deptno=scanner.nextInt();
				
				employee = new Employee(null, name,
						new GregorianCalendar(2016, 10, 15), job,
						sal, deptno);
				addNewEmployee(employee);
				break;
			case 2:
				System.out.println("Enter empid: ");
				Integer empid = scanner.nextInt();
				deleteEmployee(empid);
				
				break;
				
			case 3:
				System.out.println("Enter empid: ");
				empid = scanner.nextInt();
				System.out.println("Enter new Salary: ");
				Double newSalary=scanner.nextDouble();
				/*employee = new Employee(null, "Meghali",
						new GregorianCalendar(2016, 10, 15), "Developer",
						65750.0, 10);*/
				updateEmployee(empid, newSalary);
				break;
				
			case 4:
				System.out.println("Enter empid: ");
				empid = scanner.nextInt();
				getEmployeeDetails(empid);
				break;
				
			case 5:
				getAllEmployees();
				break;
				
			case 6:System.out.println("exit ");
				System.exit(0);
				
				
			}
		}
		
		
		
	}

	private static void getAllEmployees() {
		try {
			
			List<Employee> emplist=employeeService.getAllEmployees();
			for (Employee employee : emplist) 
			{
				System.out.println(employee);
			}
					
			} 
		catch (EmployeeException e) 
		{			
			e.getMessage();
			//e.printStackTrace();
		}
		
	}

	private static void getEmployeeDetails(Integer empid) {
		try {
			Employee e1=employeeService.getEmployeeDetails(empid);
			System.out.println(e1);
			} 
		catch (EmployeeException e) 
		{			
			e.getMessage();
			//e.printStackTrace();
		}
	}

	private static void updateEmployee(Integer empid, Double newSalary) 
	{
		try {
			employee=employeeService.getEmployeeDetails(empid);
			System.out.println(employee);
			employee.setSalary(newSalary);
			employeeService.updateEmployee(employee);
			employee=employeeService.getEmployeeDetails(empid);
			System.out.println(employee);
			//employeeService.updateEmployee(employee);		
			} 
		catch (EmployeeException e) 
		{			
			e.getMessage();
			//e.printStackTrace();
		}
	}

	private static void deleteEmployee(Integer empid) {
		try {
			employeeService.deleteEmployee(empid);		
			} 
		catch (EmployeeException e) 
		{			
			e.getMessage();
			//e.printStackTrace();
		}
		
	}

	private static void addNewEmployee(Employee employee) {
		try {
			employeeService.addNewEmployee(employee);
		} catch (EmployeeException e) {			
			e.getMessage();
			//e.printStackTrace();
		}
		
	}

}

