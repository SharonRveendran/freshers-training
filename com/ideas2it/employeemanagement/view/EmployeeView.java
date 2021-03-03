package com.ideas2it.employeemanagement.view;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import java.util.Scanner;

import com.ideas2it.employeemanagement.controller.EmployeeController;

/**
 * Class for Employee view
 * @author Sharon V
 * @created 02-03-2021
 */
public class EmployeeView {
    Scanner scanner = new Scanner(System.in);
    EmployeeController employeeController = new EmployeeController();
    
    /**
     * This method will collect the input option from user
     */
    public void getInput() {
    	int id = 0;
    	String message = "\nSelect your option\n1 : Create employee\n"
 	        + "2 : Read employee\n3 : Update employee\n"
 	        + "4 : Delete employee\n5 : Display all\n6 : Exit";
	String option = "0";
        do {
            System.out.println(message); 
            option = scanner.nextLine();
            switch (option) {
   	        case "1":
   	            createEmployee();
   		    break;
   	        case "2":
   	            displayEmployee();
   		    break;	
   	        case "3":
   	            updateEmployee();
   		    break;
   	        case "4":
   	            deleteEmployee();
   		    break;
   	        case "5":
   	            displayAll();
   	            break;
   	        case "6":
   	            System.out.println("Thank you....");
   	            break;
   	        default:
   	            System.out.println("Please enter a valid option");
   	    } 	 
	} while(!"6".equals(option));   
    }
    
    /**
     * Method to create employee
     */
    private void createEmployee() {
        long salary ;
    	System.out.println("Enter name");
    	String name = scanner.nextLine();
    	System.out.println("Enter designation");
    	String designation = scanner.nextLine();
    	salary = isValidSalary();
    	long mobile = getAndValidateMobile();
    	Date dob = getDob();
    	if (employeeController.createEmployee(name, designation, salary, mobile, dob)) {
    	    System.out.println("\nEmployee created successfully...");
    	}
    }
	
    /**
     * Method to get the date of birth of employee
     * @return Employee date of birth
     */
    private Date getDob() {
        String date;
        System.out.println("Enter new date in given format dd/mm/yyyy");      
        do {
            date = scanner.nextLine();
	    if (null == employeeController.isValidDate(date)) { 
	        System.out.println("Enter a valid date");
	        date = "invalidDate";
            }
        } while("invalidDate".equals(date));
        return employeeController.isValidDate(date);
    }
    
    /**
     * Method to display employee based on employee id
     */
    private void displayEmployee() {
        int id = getAndValidateId();
    	String employeeDetails = employeeController.displayEmployee(id);
    	if(null == employeeDetails) {
    	    System.out.println("No employee present with the given id...");
    	} else {
    	    System.out.println(employeeDetails);
    	}
    }
    /**
     * Method to update the employee details
     */
    private void updateEmployee() {
        int option;
    	int id = getAndValidateId();
    	if (employeeController.isIdExist(id)) {	
    	    String message = "What you want to update\n1 : Name\n"
                    + "2 : Designation\n3 : Salary\n4 : DOB\n5 : Mobile";
            System.out.println(message);
    	    option = isValidOption();
    	    switch (option) {
    	        case 1:
    	    	    updateName(id);
    	    	    break;
    	    	case 2:
    	    	    updateDesignation(id);
    	    	    break;
    	    	case 3:
    	    	    updateSalary(id);
    	    	    break;
    	    	case 4:
    	    	    updateDob(id);
    	    	    break;
    	    	case 5:
    	    	   updateMobile(id);
    	    }
    	} else {
    	    System.out.println("No employee present with the given id....");
    	}		
    }
    /**
     * This method will validate the option
     */
    private int isValidOption() {
        int option;
   	do {
	    try {	    
 	        option = Integer.parseInt(scanner.nextLine());
 	         if(option > 5) {
 	             throw new  NumberFormatException();
 	         }
 	     } catch (NumberFormatException e) {
 	         System.out.println("Enter a valid option");
 	         option = 6;
             }
	 } while (option == 6);
   	 return option;
    }
	
    /**
     * Method to validate the employee id
     * @return employee id
     */
    private int getAndValidateId() {
        System.out.println("Enter employee id");
        int id;
        do {
    	    try {
 	        id = Integer.parseInt(scanner.nextLine());
 	        if (0 == id) {
 	            throw new NumberFormatException();
 	        }  
 	        return id;
    	    } catch (NumberFormatException e) {
 		System.out.println("Enter a valid employee id");
 		id = 0;
 	    }
    	} while(0 == id);
    	return 0;
    }
	
    /**
     * This method will update the employee name
     * @param id the employee id
     */
    private void updateName(int id) {
    	System.out.println("Enter new Name");
        String employeeName = scanner.nextLine();
        if(employeeController.isIdExist(id)) {
            employeeController.updateName(id, employeeName);
            System.out.println("Employee name updated successfully....");
        } else {
            System.out.println("No employee present with the given id");
        }  
    }
    
    /**
     * This method will update the employee Designation
     * @param id the employee id
     */
    private void updateDesignation(int id) {
    	System.out.println("Enter new Designation");
        String designation = scanner.nextLine();
        employeeController.updateDesignation(id, designation);
        System.out.println("Designation updated successfully....");
    }
    
    /**
     * This method will update the employee Salary
     * @param id the employee id
     */
    private void updateSalary(int id) {
    	long employeeSalary = isValidSalary();
        employeeController.updateSalary(id, employeeSalary);
        System.out.println("\n Salary updated successfully...");
    }
    
    /**
     * Method to validate Employee salary
     */
    private long isValidSalary() {
    	System.out.println("Enter Salary");
    	long employeeSalary;
    	do {  	    
            try {
               employeeSalary = Long.parseLong(scanner.nextLine());          
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid salary");
                employeeSalary = 0;
            }
        } while (0 == employeeSalary);
    	return employeeSalary;
    }
    
    /**
     * This method will update the employee Date of birth
     * @param id the employee id
     */
    private void updateDob(int id) {
    	System.out.println("Enter new date in given format dd/mm/yyyy");
    	String date;
    	do {
            date = scanner.nextLine();
	    if (null == employeeController.isValidDate(date)) { 
                System.out.println("Enter a valid date");
	        date = "invalidDate";
            }
        } while("invalidDate".equals(date));
	employeeController.updateDob(id, employeeController.isValidDate(date));
	System.out.println("Date of birth updated successfully....");
    }
    
    /**
     * This method will update the employee Mobile number
     * @param id the employee id
     */
    private void updateMobile(int id) {
    	String input;
    	long mobile = getAndValidateMobile();
        employeeController.updateMobile(id, mobile);
        System.out.println("Mobile updated successfully....");
    }
    
    /**
     * Method to validate Employee mobile number
     */
    private long getAndValidateMobile() {
    	long mobile;
    	System.out.println("Enter new mobile number");
        do {  	    
            String input = scanner.nextLine();
      	    if (Pattern.matches("[7-9][0-9]{9}", input)) {
      	        mobile = Long.parseLong(input); 
      	    } else {
      	    	mobile = 0;
     	    	System.out.println("Enter valid mobile number");
      	    }
         } while (0 == mobile);
         return mobile;      
    }
    
    /**
     * Method to delete employee based on employee id
     */
    private void deleteEmployee() { 
    	int id = getAndValidateId() ;
    	if (employeeController.isIdExist(id)) {
            employeeController.deleteEmployee(id);
            System.out.println("Employee deleted Successfully...");
    	} else {
    		System.out.println("No employee present with the given id....");
    	}
    }
    
    /**
     * Method to display all employee details present in collection
     */
    private void displayAll() {
        List<String> employees = employeeController.displayAll();
        if (0 == employees.size()) {
            System.out.println(" No employee present in collection");
        } else {
            for(String employeeDetails : employees) {
                System.out.println(employeeDetails);
            }
        }
    }		
}
