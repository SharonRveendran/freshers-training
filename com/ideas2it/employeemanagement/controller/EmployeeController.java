package com.ideas2it.employeemanagement.controller;

import java.util.Date;

import com.ideas2it.employeemanagement.model.Employee;
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
    		,long salary, long mobile, Date dob) {
    	return employeeService.createEmployee(name, designation, salary, mobile, dob);
    }
    
    /**
     * Method to read the employee based on employee id
     * @param id Employee id
     * @return Employee 
     */
    public Employee readEmployee(int id) {
    	return employeeService.readEmployee(id);
    }
    
    /**
     * Methode to update the employee name
     * @param id Employee id
     * @param employeeName Name of employee
     * @return true for successful updation of name else return false
     */
    public boolean updateName(int id, String employeeName) {
    	return employeeService.updateName(id, employeeName);
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
    	employeeService.updateDesignation(id, designation);
    }
    
    /**
     * Method to update Employee salary
     * @param id Employee id
     * @param employeeSalary Salary of Employee
     */
    public void updateSalary(int id, long employeeSalary) {
    	employeeService.updateSalary(id, employeeSalary);
    }
    
    /**
     * Method to update Employee date of birth
     * @param id Employee id
     * @param dob Employee date of birth
     */
    public void updateDob(int id, Date dob) {
    	employeeService.updateDob(id, dob);
    }
    
    /**
     * Method to update employee mobile number
     * @param id Employee id
     * @param mobile Employee mobile number
     */
    public void updateMobile(int id, long mobile) {
    	employeeService.updateMobile(id, mobile);
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
    public boolean displayAll() {
    	return employeeService.displayAll();
    }
}
