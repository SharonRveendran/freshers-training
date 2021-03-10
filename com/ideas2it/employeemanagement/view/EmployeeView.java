package com.ideas2it.employeemanagement.view;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import com.ideas2it.employeemanagement.constants.Constants;
import com.ideas2it.employeemanagement.controller.EmployeeController;

/**
 * Class for Employee view
 * @author Sharon V
 * @created 09-03-2021
 */
public class EmployeeView {
    Constants constants = new Constants();
    Scanner scanner = new Scanner(System.in);
    EmployeeController employeeController = new EmployeeController();
    
    /**
     * This method will collect the input option from user
     * and perfom CRUD operation
     */
    public void getInput() throws SQLException {
	String option = "0";
        do {
            System.out.println(constants.crudOption); 
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
   	            System.out.println(constants.endMassege);
   	            break;
   	        default:
   	            System.out.println(constants.invalidDetails);
   	    } 	 
	} while(!"6".equals(option));   
    }
    
    /**
     * Method to create employee
     */
    private void createEmployee() throws SQLException {
    	System.out.println(constants.getName);
    	String name = scanner.nextLine();
    	System.out.println(constants.getDesignation);
    	String designation = scanner.nextLine();
    	long salary = getAndValidateSalary();
    	long mobile = getAndValidateMobile();
    	Date dob = getDob();
        System.out.println("Provide permanent address details");
        String permanentAddress[] = getAddress();
        System.out.println("Provide temporary address details");
        String temporaryAddress[] = getAddress();
    	if (employeeController.createEmployee(name, designation, salary, mobile,
                dob,permanentAddress, temporaryAddress)) {
    	    System.out.println(constants.successfullCreation);
    	}
    }
     
    /**
     * Method to get Address details
     * @return array of employee address details
     */
    private String[] getAddress() { 
        String address[] = new String[5];    
        System.out.println("Enter door number");
        address[0] = scanner.nextLine();
        System.out.println("Enter street");
        address[1] = scanner.nextLine();
        System.out.println("Enter District");
        address[2] = scanner.nextLine();
        System.out.println("Enter State");
        address[3] = scanner.nextLine();
        System.out.println("Enter Country");
        address[4] = scanner.nextLine();
        return address;
    }

    /**
     * Method to get the date of birth of employee
     * @return Employee date of birth
     */
    private Date getDob() {
        String date;
        System.out.println(constants.getDate);      
        do {
            date = scanner.nextLine();
	    if (null == employeeController.isValidDate(date)) { 
	        System.out.println(constants.invalidDetails);
	        date = "invalidDate";
            }
        } while("invalidDate".equals(date));
        return employeeController.isValidDate(date);
    }
    
    /**
     * Method to display employee based on employee id
     */
    private void displayEmployee() throws SQLException{
        int id = getAndValidateId();
    	String employeeDetails = employeeController.getEmployee(id);
    	if(null == employeeDetails) {
    	    System.out.println(constants.noEmployee);
    	} else {
    	    System.out.println(employeeDetails);
    	}
    }
    /**
     * Method to update the employee details
     */
    private void updateEmployee() throws SQLException {
    	int id = getAndValidateId();
    	if (employeeController.isIdExist(id)) {	
            System.out.println(constants.updateOption);
            String option = scanner.nextLine();
    	    switch (option) {
    	        case "1":
    	    	    updateName(id);
    	    	    break;
    	    	case "2":
    	    	    updateDesignation(id);
    	    	    break;
    	    	case "3":
    	    	    updateSalary(id);
    	    	    break;
    	    	case "4":
    	    	    updateDob(id);
    	    	    break;
    	    	case "5":
    	    	   updateMobile(id);
                   break;
                case "6":
    	    	   updateAddress(id);
                   break;
                default:
                   System.out.println(constants.invalidDetails);
    	    }
    	} else {
    	    System.out.println(constants.noEmployee);
    	}		
    }

    /**
     * Method to get and validate the employee id
     * @return employee id
     */
    private int getAndValidateId() throws SQLException {
        System.out.println(constants.getId);
        String input;
        int id = 0;
        do {
            input = scanner.nextLine();
            id = employeeController.isValidId(input); 
            if (0 == id) {
                System.out.println(constants.invalidDetails);
            }     
    	} while(0 == id);
    	return id;
    }
	
    /**
     * This method will update the employee name
     * @param id the employee id
     */
    private void updateName(int id) throws SQLException {
    	System.out.println(constants.getName);
        String employeeName = scanner.nextLine();
        if(employeeController.isIdExist(id)) {
            employeeController.updateName(id, employeeName);
            System.out.println(constants.successfullUpdation);
        } else {
            System.out.println(constants.noEmployee);
        }  
    }
    
    /**
     * This method will update the employee Designation
     * @param id the employee id
     */
    private void updateDesignation(int id) throws SQLException {
    	System.out.println(constants.getDesignation);
        String designation = scanner.nextLine();
        employeeController.updateDesignation(id, designation);
        System.out.println(constants.successfullUpdation);
    }
    
    /**
     * This method will update the employee Salary
     * @param id the employee id
     */
    private void updateSalary(int id) throws SQLException {
    	long employeeSalary = getAndValidateSalary();
        employeeController.updateSalary(id, employeeSalary);
        System.out.println(constants.successfullUpdation);
    }
    
    /**
     * Method to get and validate Employee salary
     * @return valid salary
     */
    private long getAndValidateSalary() {
    	System.out.println(constants.getSalary);
    	String input;
    	do {  
            input = scanner.nextLine();	    
            if(0 == employeeController.isValidSalary(input)) {
                System.out.println(constants.invalidDetails);
                input = null;          
            } 
        } while (null == input);
    	return employeeController.isValidSalary(input);
    }
    
    /**
     * This method will update the employee Date of birth
     * @param id the employee id
     */
    private void updateDob(int id) throws SQLException {
    	System.out.println(constants.getDate);
    	String date;
    	do {
            date = scanner.nextLine();
	    if (null == employeeController.isValidDate(date)) { 
                System.out.println(constants.invalidDetails);
	        date = "invalidDate";
            }
        } while("invalidDate".equals(date));
	employeeController.updateDob(id, employeeController.isValidDate(date));
	System.out.println(constants.successfullUpdation);
    }
    
    /**
     * This method will update the employee Mobile number
     * @param id the employee id
     */
    private void updateMobile(int id) throws SQLException {
    	String input;
    	long mobile = getAndValidateMobile();
        employeeController.updateMobile(id, mobile);
        System.out.println(constants.successfullUpdation);
    }
    
    /**
     * Method to get and validate Employee mobile number
     * @return valid mobile number
     */
    private long getAndValidateMobile() {
        String input;
    	long mobile = 1;
    	System.out.println(constants.getMobile);
        do {  	    
            input = scanner.nextLine();
      	    if (0 == employeeController.isValidMobile(input)) {
                System.out.println(constants.invalidDetails);
      	        mobile = 0;
      	    } else {
                mobile = employeeController.isValidMobile(input);
            }
         } while (0 == mobile);
         return mobile;      
    }
    
    /**
     * Method to delete employee based on employee id
     */
    private void deleteEmployee() throws SQLException { 
    	int id = getAndValidateId() ;
        if (0 == id) {
            System.out.println(constants.invalidDetails);  
    	} else if (employeeController.isIdExist(id)) {
            employeeController.deleteEmployee(id);
            System.out.println(constants.successfullDeletion);
    	} else {
    		System.out.println(constants.noEmployee);
    	}
    }
    
    /**
     * Method to display all employee details present in collection
     */
    private void displayAll() throws SQLException {
        List<String> employeesDetails = employeeController.getAll();
        if (0 == employeesDetails.size()) {
            System.out.println(constants.noEmployee);
        } else {
            for(String employeeDetails : employeesDetails) {
                System.out.println(employeeDetails);
            }
        }
    }
    /**
     * Methode to update employee address
     * @param id employee id
     */
    private void updateAddress(int id) throws SQLException {
        System.out.println("\n What do you want to update ?\n1 : "
                + "Permanent address\n2 : Temporary address");
        String option = scanner.nextLine();
        String addressDetails[] = getAddress();
        employeeController.updateAddress(id, addressDetails, option);
        System.out.println(constants.successfullUpdation);
    }		
}
