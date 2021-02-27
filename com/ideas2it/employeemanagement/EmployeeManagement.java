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
 * @created 28-02-2021
 */
public class EmployeeManagement {
    int id = 0;
    Map<Integer, Employee> employees = new HashMap<Integer, Employee>();
    static Scanner scanner = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyy");
	
    public static void main(String[] args) { 
        EmployeeManagement employeeManagement = new EmployeeManagement();
        int flag = 0;	
        String message = "\nSelect your option\n1 : Create employee\n"
                + "2 : Read employee\n3 : Update employee\n"
 	        + "4 : Delete employee\n5 : Display all\n6 : Exit";
        int option = 0;
	do {
	    do {
	        System.out.println(message);
		try {
		    option = Integer.parseInt(scanner.nextLine());
		    flag = 1;
    	        } catch (NumberFormatException e) {
    		    System.out.println("Please enter a valid option");
    	        }
	    } while (0 == flag);
                employeeManagement.start(option, message, employeeManagement);
	} while(6 != option);   			
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
    	do {  	    
    	    try {
    	        salary = Long.parseLong(scanner.nextLine());
    	        flag = 1;
    	    } catch (NumberFormatException e) {
    		    System.out.println("Please enter a valid salary");
    	    }
    	} while (0 == flag);
    	long mobile = createMobile();
    	Date dob = createDob();
    	Employee employee = new Employee(name, designation, salary, id, mobile, dob);
    	employees.put(id, employee);   	
    	System.out.println("\nEmployee created successfully...\n");
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
    	System.out.println("Enter employee id"); 
    	int id = isValidId() ;
    	if (0 != id) {	
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
     * @return  mobile number
     */
    private long createMobile() {
    	long mobile = 0l;
    	int flag = 0;
    	System.out.println("Enter mobile");
    	do{  	
    	    try {
    	    	mobile = Long.parseLong(scanner.nextLine());
    	        flag = 1;
    	    } catch (Exception e) {
    		    System.out.println("Please enter a valid mobile");
    	    }
    	} while (flag == 0);
    	return mobile;
    }
    
    /**
     * Check whether the employee id is valid or not
     * @return  the employee id
     */
    private int isValidId() {int x = 0;
    	do {
    	    try {
 	            id = Integer.parseInt(scanner.nextLine());
 	            if ( null == employees.get(id)) {
     	            System.out.println("No employee present with the given id");x=1;
     	            return 0;
     	        } else {
     	    	    Employee employee = employees.get(id);x=1;
                }
    	     } catch (NumberFormatException e) {
 		        System.out.println("Enter a valid employee id");
 	         }
    	} while(0 == x);
        return id;
    }
    
    /*
     * This method will update the employee name
     * @param id the employee id
     */
    private void updateName(int id) {
    	Employee employee = employees.get(id);
    	System.out.println("Enter new Name");
        String employeeName = scanner.nextLine();
        employee.setName(employeeName);  	
    }
    
    /*
     * This method will update the employee Designation
     * @param id the employee id
     */
    private void updateDesignation(int id) {
    	Employee employee = employees.get(id);
    	System.out.println("Enter new Designation");
        String newDesignation = scanner.nextLine();
        employee.setDesignation(newDesignation);
    }
    
    /*
     * This method will update the employee Salary
     * @param id the employee id
     */
    private void updateSalary(int id) {
    	Employee employee = employees.get(id);
    	System.out.println("Enter new Salary");
    	int flag = 0;
        do {  	    
            try {
               long newSalary = Long.parseLong(scanner.nextLine());
               employee.setSalary(newSalary);
               flag = 1;
               
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid salary");
            }
        } while (flag == 0);
    }
    
    /*
     * This method will update the employee Date of birth
     * @param id the employee id
     */
    private void updateDob(int id) {
    	int flag = 0;
    	Employee employee = employees.get(id);
    	System.out.println(" Enter new date in given format dd/mm/yyyy");
		do {
		    String date =scanner.nextLine();
		    try {
			    Date dob =sdf.parse(date);
			    employee.setDob(dob);
			    flag = 1;
		    } catch (ParseException e) {
		        System.out.println("Enter a valid date ");
		    }
		} while (flag == 0);	
    }
    
    /*
     * This method will update the employee Mobile number
     * @param id the employee id
     */
    private void updateMobile(int id) {
        Employee employee = employees.get(id);
        System.out.println("Enter new mobile number");
        int flag = 0;
        do {  	    
            try {
                long mobile = Long.parseLong(scanner.nextLine());
                employee.setMobile(mobile);
                flag = 1;              
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid mobile");
            }
        } while (flag == 0);
    }
    
    /*
     * This method will create the employee Date of birth
     */
     private Date createDob() {
    	 int flag = 0;
    	 Date dob = null;
    	 String date;
    	 System.out.println("Enter new date in given format dd/mm/yyyy");
 	 do {
             date =scanner.nextLine();
             try {
                 dob =sdf.parse(date);
 	         flag = 1;
             } catch (ParseException e) {
 	         System.out.println("Enter a valid date ");
 	     }
         }while (flag == 0);	  
 	     return dob;
     }
     
     /*
      * This method will validate the option
      */
     private int isValidOption() {
    	 int option;
    	 do {
	     try {	    
  	         option = Integer.parseInt(scanner.nextLine());
  	         if(option>5)throw new  NumberFormatException();
  	     } catch (NumberFormatException e) {
  	         System.out.println("Enter a valid option");
  	         option = 6;
             }
	 } while (option == 6);
    	 return option;
     }
     
     /*
      * This method will update start the CRUD operation
      * @param option user given option
      * @param message message for user to input option
      * @param employeeManagement EmployeeManagement class object
      */
     public void start(int option, String message, EmployeeManagement employeeManagement) {	
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
	        System.out.println("Thank you");
	        break;
	    default:
	        System.out.println("Please enter a valid option");
	} 	 
    }
}