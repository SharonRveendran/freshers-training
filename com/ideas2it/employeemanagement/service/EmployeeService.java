package com.ideas2it.employeemanagement.service;

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
     * Method to update the employee name
     * @param id Employee id
     * @param employeeName Name of employee
     * @return true for successful updation else return false
     */
    public boolean updateName(int id, String employeeName) {
    	if (null == employees.get(id)) {
    		return false;
    	} else {
    		employees.get(id).setName(employeeName);
    		return true;
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
     * Method to update Employee designation
     * @param id Employee id
     * @param designation Employee Designation
     */
    public void updateDesignation(int id, String designation) {
    	(employees.get(id)).setDesignation(designation);
    }
    
    /**
     * Method to update Employee salary
     * @param id Employee id
     * @param employeeSalary Salary of Employee
     */
    public void updateSalary(int id, long employeeSalary) {
    	(employees.get(id)).setSalary(employeeSalary);
    }
    
    /**
     * Method to update Employee date of birth
     * @param id Employee id
     * @param dob Employee date of birth
     */
    public void updateDob(int id, Date dob) {
    	(employees.get(id)).setDob(dob);
    }
    
    /**
     * Method to update employee mobile number
     * @param id Employee id
     * @param mobile Employee mobile number
     */
    public void updateMobile(int id, long mobile) {
    	(employees.get(id)).setMobile(mobile);
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
}
