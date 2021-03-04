package com.ideas2it.employeemanagement.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.ideas2it.employeemanagement.model.Employee;

/**
 * Class for Employee service
 * @author Sharon V
 * @created 04-03-2021
 */
public class EmployeeService {
    Map<Integer, Employee> employees = new HashMap<Integer, Employee>();
    int id = 0;
	
    /**
     * Method to create employee
     * @param name  Employee Name
     * @param designation  Employee Designation
     * @param salary  Employee salary
     * @param mobile  Employee Mobile number
     * @param dob  Employee Date of birth  
     * @return  true for successful insertion and false for insertion failure
     */
    public boolean createEmployee(String name, String designation
            ,long salary, long mobile, Date dob) {
        id++;
    	Employee employee = new Employee(name, designation, salary, id, mobile, dob);
        return ((null == employees.put(id, employee)) ? true :false);
    }
    
    /**
     * Method to return employee details based on employee id
     * @param id Employee id
     * @return employee object if employee present else return null
     */
    public String getEmployee(int id) {
        if (!isIdExist(id)) {
            return null;
        } else {
            return (employees.get(id)).toString();
        }
    }
    
    /**
     * Methode to update all employee details
     * @param id Employee id
     * @param employeeDetail1 employee details include name and designation of employee
     * @param employeeDetails2 employee details include salary and mobile of employee
     * @param employeeDetails3 Date of birth of employee
     */
    public void updateEmployee(int id, String name, String designation,
            long salary, Date dob, long mobile, String option) {
    	if ("name".equals(option)) {
    	     employees.get(id).setName(name);
    	}
    	if ("designation".equals(option)) {
    	    (employees.get(id)).setDesignation(designation);
    	}
    	if ("salary".equals(option)) {
    	    (employees.get(id)).setSalary(salary);
    	}
    	if ("dob".equals(option)) {
    	    (employees.get(id)).setDob(dob);
    	}
    	if ("mobile".equals(option)) {
    	    (employees.get(id)).setMobile(mobile);
    	}
    }
   
    /**
     * Method to check whether the id is present in collection or not 
     * @param id Employee id
     * @return true if id present in collection else return false
     */
    public boolean isIdExist(int id) {
        return ((null == employees.get(id)) ? false : true);
    }
     
    /**
     * Method to delete the Employee based on employee id
     * @param id Employee id
     */
    public void deleteEmployee(int id) {
    	employees.remove(id);
    }
    
    /**
     * Method to return all employee details present in collection
     * @return list of employee details
     */
    public List<String> getAll() {
        List<String> employeeDetails = new ArrayList<String>();
        for(Employee employee : employees.values()) {
                employeeDetails.add(employee.toString());
            }
    	return employeeDetails;
    }
    
    /**
     * Method to validate date
     * @param date
     * @return valid date
     */
    public Date isValidDate(String date) {
    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    	Date dob = null;
        try {
	    dob = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            return null;
        }
        return dob;
    }
 
    /**
     * Methode to validate mobile number
     * @param input user given input for mobile
     * @return valid mobile number
     */
    public long isValidMobile(String input) {
        if (Pattern.matches("[7-9][0-9]{9}", input)) {
      	    long mobile = Long.parseLong(input); 
            return mobile;
      	} else {
      	   return 0l;
      	}
    }
    /** 
     * This methode will validate employee salary
     * @param input user given input for salary
     * @return valid employee salary
     */
    public long isValidSalary(String input) {
        long employeeSalary;
        try {
            employeeSalary = Long.parseLong(input);          
        } catch (NumberFormatException e) {
            return 0;
        }
        return employeeSalary;
    }

    /**
     * This method will validate employee id
     * @param id employee id
     * @return valid employee id
     */
    public int isValidId(String id) {
        int validId;
        try {
 	    validId = Integer.parseInt(id);
 	    if (0 == validId) {
 	        throw new NumberFormatException();
 	    }  
    	} catch (NumberFormatException e) {
            return 0;
 	}
        return validId;
    }
}
