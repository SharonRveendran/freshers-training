package com.ideas2it.employeemanagement.controller;

import java.util.Date;
import java.util.List;

import com.ideas2it.employeemanagement.service.EmployeeService;

/**
 * Class for Employee controller
 * @author Sharon V
 * @created 01-03-2021
 */
public class EmployeeController {
    EmployeeService employeeService = new EmployeeService();
    
    /**
     * Method to create employee
     * @param name  Employee name
     * @param designation Employee designation
     * @param salary  Employee salary
     * @param mobile  Employee mobile number
     * @param dob  Employee date of birth
     * @return true for successful creation else return false
     */
    public boolean createEmployee(String name, String designation
    		, long salary, long mobile, Date dob) {
    	return employeeService.createEmployee(name, designation, salary, mobile, dob);
    }
    
    /**
     * Method to display the employee based on employee id
     * @param id Employee id
     * @return Employee 
     */
    public String displayEmployee(int id) {
    	return employeeService.displayEmployee(id);
    }
    
    /**
     * Methode to update the employee name
     * @param id Employee id
     * @param employeeName Name of employee
     * @return true for successful updation of name else return false
     */
    public void updateName(int id, String employeeName) {
    	employeeService.updateEmployee(id, employeeName, null, 0l, null, 0l, "name");
    }
    
    /**
     * Method to check whether the id is present in collection or not 
     * @param id Employee id
     * @return true if id present in collection else return false
     */
    public boolean isIdExist(int id) {
    	return employeeService.isIdExist(id);
    }
    
    /**
     * Method to update Employee designation
     * @param id Employee id
     * @param designation Employee Designation
     */
    public void updateDesignation(int id, String designation) {
    	employeeService.updateEmployee(id, null, designation
                , 0l, null, 0l, "designation");
    }
    
    /**
     * Method to update Employee salary
     * @param id Employee id
     * @param employeeSalary Salary of Employee
     */
    public void updateSalary(int id, long employeeSalary) {
    	employeeService.updateEmployee(id, null, null,
                employeeSalary, null, 0l, "salary");
    }
    
    /**
     * Method to update Employee date of birth
     * @param id Employee id
     * @param dob Employee date of birth
     */
    public void updateDob(int id, Date dob) {
    	employeeService.updateEmployee(id, null, null, 0l, dob, 0l, "dob");
    }
    
    /**
     * Method to update employee mobile number
     * @param id Employee id
     * @param mobile Employee mobile number
     */
    public void updateMobile(int id, long mobile) {
    	employeeService.updateEmployee(id, null, null, 0l, null, mobile, "name");
    }
    
    /**
     * Method to delete the Employee based on employee id
     * @param id Employee id
     */
    public void deleteEmployee(int id) {
    	employeeService.deleteEmployee(id);
    }

    /**
     * Method to display all employee present in collection
     * @return false if collection is empty else return true
     */
    public List<String> displayAll() {
    	return employeeService.displayAll();
    }
    
    /**
     * Method to validate date
     * @param date User given date string
     * @return valid date
     */
    public Date isValidDate(String date) {
    	return employeeService.isValidDate(date);
    }
}
