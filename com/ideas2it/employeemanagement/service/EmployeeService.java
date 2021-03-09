package com.ideas2it.employeemanagement.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.ideas2it.employeemanagement.model.Employee;

/**
 * Class for Employee service
 * @author Sharon V
 * @created 09-03-2021
 */
public interface EmployeeService {
	
    /**
     * Method to create employee
     * @param name  Employee Name
     * @param designation  Employee Designation
     * @param salary  Employee salary
     * @param mobile  Employee Mobile number
     * @param dob  Employee Date of birth  
     * @return  true for successful insertion and false for insertion failure
     */
    public boolean createEmployee(String name, String designation,
            long salary, long mobile, Date dob) throws ClassNotFoundException, 
            SQLException;
    
    /**
     * Method to return employee details based on employee id
     * @param id Employee id
     * @return employee object if employee present else return null
     */
    public String getEmployee(int id) throws ClassNotFoundException, SQLException;
        
    /**
     * Methode to update employee details
     * @param id Employee id
     * @param name employee name
     * @param designation employee designation
     * @param salary employee salary
     * @param dob employee date of birth
     * @param mobile employee mobile number
     * @param option option to specify the attribute that need to update
     */
    public void updateEmployee(int id, String name, String designation,
            long salary, Date dob, long mobile, String option)
            throws ClassNotFoundException, SQLException;
   
    /**
     * Method to check whether the id is present in collection or not 
     * @param id Employee id
     * @return true if id present in collection else return false
     */
    public boolean isIdExist(int id) throws ClassNotFoundException, SQLException;
     
    /**
     * Method to delete the Employee based on employee id
     * @param id Employee id
     */
    public void deleteEmployee(int id) throws ClassNotFoundException, SQLException;
    	
    /**
     * Method to return all employee details present in collection
     * @return list of employee details
     */
    public List<String> getAll() throws SQLException, ClassNotFoundException;
        
    /**
     * Method to validate date
     * @param date
     * @return valid date
     */
    public Date isValidDate(String date);
    	
    /**
     * Methode to validate mobile number
     * @param input user given input for mobile
     * @return valid mobile number
     */
    public long isValidMobile(String input);
        
    /** 
     * This methode will validate employee salary
     * @param input user given input for salary
     * @return valid employee salary
     */
    public long isValidSalary(String input);
        
    /**
     * This method will validate employee id
     * @param id employee id
     * @return valid employee id
     */
    public int isValidId(String id);
}
