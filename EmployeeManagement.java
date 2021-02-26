package com.ideas2it.employeemanagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.ideas2it.employeemanagement.model.Employee;

/**
 * Doing CRUD operation in collection
 * @author Sharon
 * @created 23-02-2021
 */
public class EmployeeManagement {
    int id = 0;
    Map<Integer, Employee> employees = new HashMap<Integer, Employee>();
    static Scanner scanner = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public static void main(String[] args) { 
	int flag = 0;
	EmployeeManagement employeeManagement = new EmployeeManagement();
	String message = "\nSelect your option\n1 : Create employee\n"
	    	+ "2 : Read employee\n3 : Update employee\n"
	    	+ "4 : Delete employee\n5 : Display all\n6 : Exit";
	while (0 == flag) {
	    System.out.println(message);
            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1:
                    employeeManagement.createEmployee();
		    break;
                case 2:
		    employeeManagement.readEmployee();
		    break;	
	        case 3:
		    employeeManagement.updateEmployee();
		    break;
	        case 4:
		    employeeManagement.deleteEmployee();
		    break;
	        case 5:
		    employeeManagement.displayAll();
		    break;
	        case 6:
		    flag = 1;
		    System.out.println("Thank you");
	        default:
		    System.out.println("Please enter a valid option");
	    }	
	}		
    }
	
    /**
     * Creating employee and storing in map
     */
    private void createEmployee() {
    	id++;
    	long salary = 0l;
    	int flag = 0;
    	System.out.println("Enter name");
    	String name = scanner.nextLine();
    	System.out.println("Enter designation");
    	String designation = scanner.nextLine();
    	System.out.println("Enter salary");
    	while (0 == flag) {  	    
    	    try {
    	        salary = Integer.parseInt(scanner.nextLine());
    	        flag = 1;
    	    } catch (NumberFormatException e) {
    		    System.out.println("Please enter a valid salary");
    	    }
    	}
    	long mobile = createMobile();
    	System.out.println(" Enter date in given format dd/mm/yyyy");
        while (1 == flag) {
	   String date =scanner.nextLine();
	   try {
	       Date dob =sdf.parse(date);
	       Employee employee = new Employee(name, designation, salary, id, mobile, (sdf.format(dob)));
	       employees.put(id, employee);
	       flag = 3;
	   } catch (ParseException e) {
	       System.out.println("Enter a valid date ");
	   }
        }  	
    }
    
    /**
     * Displaying employee details based on employee id
     */
    private void readEmployee() {
    	int flag =0;
    	int id =0;
    	System.out.println("Enter the employee id");
    	while (0 == flag) {  	    
    	    try {
    	        id = Integer.parseInt(scanner.nextLine());
    	        flag = 1;
    	    } catch (NumberFormatException e) {
    		    System.out.println("Please enter a valid employee id");
    	    }
    	}
    	if ( null == employees.get(id)) {
    		System.out.println("No employee present with the given id");
    	} else {
    	System.out.println(employees.get(id));
    	}
    }
    
    /**
     * Updating employee details based on employee id
     */
    private void updateEmployee() {
        int option;
    	int flag1 = 0;
    	int flag2 = 0;
    	int flag3 = 0;
    	int flag4 = 0;
    	System.out.println("Enter employee id"); 
    	while(0 == flag1) {
    		flag1 =1;
    	    try {
    	        id = Integer.parseInt(scanner.nextLine());
    	        if ( null == employees.get(id)) {
        	        System.out.println("No employee present with the given id");
        	    } else {
        	    	Employee employee = employees.get(id);
        	    	String message = "What you want to update\n1 : Name\n"
        	    			+ "2 : Designation\n3 : Salary\n4 : DOB\n5 : Mobile";
        	    	System.out.println(message);
        	        while (0 == flag3) {
        	    	    try {
        	    	        option = Integer.parseInt(scanner.nextLine());
        	    	    } catch (NumberFormatException e) {
        	    	        option = 4;
        	            }
        	            flag3 = 1;
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
        	    		    while (0 == flag2) {  	    
        	    		        try {
        	    		           int newSalary = Integer.parseInt(scanner.nextLine());
        	    		            employee.setSalary(newSalary);
        	    		            flag2 = 1;
        	    		        } catch (NumberFormatException e) {
        	    		            System.out.println("Please enter a valid salary");
        	    		        }
        	    		    }
        	    		    break;	
        	    	        case 4:
        	    	            System.out.println(" Enter new date in given format dd/mm/yyyy");
        	    	    	    while (0 == flag4) {
        	    	    		String date =scanner.nextLine();
        	    	    		try {
        	    	    	            Date dob =sdf.parse(date);
        	    	    	            employee.setDob(sdf.format(dob));
        	    	    		    flag4 = 1;
        	    	    		} catch (ParseException e) {
        	    	    		    System.out.println("Enter a valid date ");
        	    	    		}
        	    	            }
        	    	            break;
        	    	        case 5:
        	    	            System.out.println("Enter new mobile number");
        	    	            long mobile = scanner.nextLong();
        	    	            scanner.nextLine();
        	    	            employee.setMobile(mobile);
        	    	            break;
        	    	        default:
        	    		    System.out.println("Enter a valid input");
        	    		    flag3 = 0;
        	    	    }
        	        }
        	    }
    	    } catch (NumberFormatException e) {
    		    System.out.println("Enter a valid employee id");
    		    flag1 = 0;
    	    }   
    	}
    }
    
    /**
     * Displaying all employees
     */
    private void displayAll() {
    	if (0 == employees.size()) {
    	     System.out.println("No employees present");
    	} else {
    		employees.forEach((id,employee) -> System.out.println(employee));
    	}
    }
    
    /**
     * Deleting employee
     */
    private void deleteEmployee() {
    	int flag = 0;
    	int id = 0;
    	System.out.println("Enter employee id");
    	while (0 == flag) {  	    
    	    try {
    	        id = Integer.parseInt(scanner.nextLine());
    	        if (null == employees.get(id)) {
    	        	System.out.println("No employee present with given id");
    	        	flag = 1;
    	        } else {
    	        employees.remove(id);
    	        System.out.println("Employee deleted successfully..");
    	        flag = 1;
    	        }
    	    } catch (NumberFormatException e) {
    		    System.out.println("Please enter a valid employee id");
    	    }
    	}
    }
    
    /**
     * 
     * @return return mobile number
     */
    private long createMobile() {
    	long mobile = 0l;
    	int flag = 0;
    	System.out.println("Enter mobile");
    	while (0 == flag) {  	    
    	    try {
    	    	mobile = scanner.nextLong();
    	    	scanner.nextLine();
    	        flag = 2;
    	    } catch (Exception e) {
    		    System.out.println("Please enter a valid mobile");
    	    }
    	}
    	return mobile;
    }
}
