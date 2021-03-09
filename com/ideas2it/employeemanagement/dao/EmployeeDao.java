package com.ideas2it.employeemanagement.dao;

import java.sql.Date;
import java.sql.SQLException;

import com.ideas2it.employeemanagement.model.Employee;

/**
 * Class to interact with database
 * @author Sharon V
 * @created 09-03-2021
 */
public interface EmployeeDao {
      
    /**
     * Method to get employee from database
     * @param id employee id
     * @return employee object
     */
     public Employee getEmployee(int id) throws SQLException, ClassNotFoundException;
 
    /**
     * Method to insert employee to database  
     * @param employee
     * @return true if employee inserted else false 
     */
     public boolean insertEmployee(Employee employee) throws ClassNotFoundException,
             SQLException;

    /**
     * Methode to delete employee based on employee id
     * @ param id employee id  
     */
     public void deleteEmployee(int id) throws ClassNotFoundException, SQLException;
         
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
}