package com.ideas2it.employeemanagement.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.ideas2it.employeemanagement.model.Employee;

/**
 * Class for Employee service
 * @author Sharon V
 * @created 01-03-2021
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
    	if (null == employees.put(id, employee)) {
    	    return true;
    	} else {
    	    return false;
    	}
    }
    
    /**
     * Method to read employee based on id
     * @param id Employee id
     * @return employee object if employee present else return null
     */
    public Employee readEmployee(int id) {
    	if (null == employees.get(id)) {
    	    return null;
    	} else {
    	    return employees.get(id);
    	}
    }
    
    /**
     * Methode to update all employee details
     * @param id Employee id
     * @param employeeDetail1 employee details include name and designation of employee
     * @param employeeDetails2 employee details include salary and mobile of employee
     * @param employeeDetails3 Date of birth of employee
     */
    public void updateEmployee(int id, String employeeDetail1,
            long employeeDetail2, Date employeedetail3) {
    	if (0l == employeeDetail2) {
    	     employees.get(id).setName(employeeDetail1);
    	}
    	if (1l == employeeDetail2) {
    	    (employees.get(id)).setDesignation(employeeDetail1);
    	}
    	if ("salary".equals(employeeDetail1)) {
    	    (employees.get(id)).setSalary(employeeDetail2);
    	}
    	if ("dob".equals(employeeDetail1)) {
    	    (employees.get(id)).setDob(employeedetail3);
    	}
    	if ("mobile".equals(employeeDetail1)) {
    	    (employees.get(id)).setMobile(employeeDetail2);
    	}
    }
   
    /**
     * Method to check whether the id is present in collection or not 
     * @param id Employee id
     * @return true if id present in collection else return false
     */
    public boolean isIdExist(int id) {
    	if (null == employees.get(id)) {
    	    return false;
    	} else {
    	    return true;
    	}
    }
     
    /**
     * Method to delete the Employee based on employee id
     * @param id Employee id
     */
    public void deleteEmployee(int id) {
    	employees.remove(id);
    }
    
    /**
     * Method to display all employee present in collection
     * @return false if collection is empty else return true
     */
    public boolean displayAll() {
    	if (0 == employees.size()) {
    	    return true;
    	} else {
    	    employees.forEach((id,employee) -> System.out.println(employee));
    	    return false;
    	}
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
     * Method to check whether the id is present in collection
     * @param id Employee id
     * @return true if id present else false
     */
    public boolean isIdPresent(int id) {
	if (null == employees.get(id)) {
    	    return false;
    	} else {
    	    return true;
    	}
    }
}
