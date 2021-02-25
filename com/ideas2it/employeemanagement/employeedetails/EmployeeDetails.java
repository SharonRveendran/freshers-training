package com.ideas2it.employeemanagement.employeedetails;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.ideas2it.employeemanagement.model.Employee;

/**
 * Doing CRUD operation in collection
 * @author Sharon
 * @created 23-02-2021
 */
public class EmployeeDetails {
    Map<Integer, Employee> employees = new HashMap<Integer, Employee>();
    static Scanner scanner = new Scanner(System.in);
    int id = 0;
    public static void main(String[] args) { 	
	EmployeeDetails employeeDetails = new EmployeeDetails();
	String message = "Select your option\n1 : Create employee\n"
		+ "2 : Read employee\n3 : Update employee\n"
	        + "4 : Delete employee\n5 : Display all\n6 : Exit";
	while (true) {
            System.out.println(message);
	    int option = Integer.parseInt(scanner.nextLine());
	    switch (option) {
                case 1:
		    employeeDetails.createEmployee();
	            break;
		case 2:
		    employeeDetails.readEmployee();
		    break;	
		case 3:
		   employeeDetails.updateEmployee();
		   break;
		case 4:
		    employeeDetails.deleteEmployee();
	            break;
		case 5:
		    employeeDetails.displayAll();
		    break;
		 case 6:
		    System.out.println("Thank you");
		    System.exit(0);
	    }	
    }		
}
	
    /**
     * Creating employee and storing in map
     */
    private void createEmployee() {
    	id++;
    	System.out.println("Enter name");
    	String name = scanner.nextLine();
    	System.out.println("Enter designation");
    	String designation = scanner.nextLine();
    	System.out.println("Enter salary");
    	long salary = Integer.parseInt(scanner.nextLine());
    	Employee employee = new Employee(name, designation, salary);
    	employee.setId(id);
    	employees.put(id, employee);
    }
    
    /**
     * Displaying employee details based on employee id
     */
    private void readEmployee() {
    	System.out.println("Enter the employee id");
    	int id = Integer.parseInt(scanner.nextLine());
    	System.out.println(employees.get(id));
    }
    
    /**
     * Updating employee details based on employee id
     */
    private void updateEmployee() {
    	System.out.println("Enter employee id");
    	int oldId = Integer.parseInt(scanner.nextLine());
    	Employee employee = employees.get(oldId);
    	String message = "What you want to update\n1 : Name\n"
    			+ "2 : Designation\n3 : Salary";
    	System.out.println(message);
    	int option = Integer.parseInt(scanner.nextLine());
    	switch (option) {
    	    case 1: 
    		System.out.println("Enter new Name");
    		String newName = scanner.nextLine();
    		employee.setName(newName);
    		break;	
    	    case 2: 
    		System.out.println("Enter new Designation");
    		String newDesignation = scanner.nextLine();
    		employee.setDesignation(newDesignation);
    		break;
    	    case 3: 
    		System.out.println("Enter new Salary");
    		int newSalary = Integer.parseInt(scanner.nextLine());
    		employee.setSalary(newSalary);
    		break;	
    	    default:
    		System.out.println("Enter a valid input");
    	}
    }
    
    /**
     * Displaying all employees
     */
    private void displayAll() {
    	employees.forEach((key,value) -> System.out.println(value));  		
    }
    
    /**
     * Deleting employee
     */
    private void deleteEmployee() {
    	System.out.println("Enter employee id");
    	employees.remove(Integer.parseInt(scanner.nextLine()));
    }
}
