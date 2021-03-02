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
    public void updateName(int id, String employeeName) {
    	employeeService.updateEmployee(id, employeeName, 0l, null);
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
    	employeeService.updateEmployee(id, designation, 1l,null);
    }
    
    /**
     * Method to update Employee salary
     * @param id Employee id
     * @param employeeSalary Salary of Employee
     */
    public void updateSalary(int id, long employeeSalary) {
    	employeeService.updateEmployee(id, "salary", employeeSalary, null);
    }
    
    /**
     * Method to update Employee date of birth
     * @param id Employee id
     * @param dob Employee date of birth
     */
    public void updateDob(int id, Date dob) {
    	employeeService.updateEmployee(id, "dob", 2l, dob);
    }
    
    /**
     * Method to update employee mobile number
     * @param id Employee id
     * @param mobile Employee mobile number
     */
    public void updateMobile(int id, long mobile) {
    	employeeService.updateEmployee(id, "mobile", mobile, null);
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
    
    /**
     * Method to validate date
     * @param date User given date string
     * @return valid date
     */
    public Date isValidDate(String date) {
    	return employeeService.isValidDate(date);
    }
    
    /**
     * Methode to check the id present in collection or not
     */
    public boolean isIdPresent(int id) {
    	return employeeService.isIdPresent(id);
    }
}
