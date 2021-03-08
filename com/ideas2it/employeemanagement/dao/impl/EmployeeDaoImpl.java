package com.ideas2it.employeemanagement.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.ideas2it.employeemanagement.model.Employee;

/**
 * Class to interact with database
 * @author Sharon V
 * @created 09-03-2021
 */
public class EmployeeDaoImpl{
    String url = "jdbc:mysql://localhost:3306/employeemanagement";
    String userName = "root";
    String password = "25562556";
    Connection connection;	
    PreparedStatement preparedStatement;
    ResultSet resultSet;
      
    /**
     * Method to get employee from database
     * @param id employee id
     * @return employee object
     */
     public Employee getEmployee(int id) throws SQLException, ClassNotFoundException  {
         connection = DriverManager.getConnection(url, userName, password);
         Class.forName("com.mysql.cj.jdbc.Driver");
         Employee employee = null;
	 preparedStatement = connection.
                 prepareStatement("select * from employee where employee_id=?");
	 preparedStatement.setInt(1, id);            
	 resultSet = preparedStatement.executeQuery();			         
	 if (resultSet.next()) {            
	     String name = resultSet.getString(2);						
	     long mobile = resultSet.getLong(3);
	     Date dob = resultSet.getDate(4);
	     String designation = resultSet.getString(5);
	     long salary = resultSet.getLong(6);
	     employee = new Employee(name, designation, salary, id, mobile, dob);
             return employee;
	} else {
	    return null;
	}	      
    }
        
    /**
     * Method to insert employee to database  
     * @param employee
     * @return true if employee inserted else false 
     */
     public boolean insertEmployee(Employee employee) throws ClassNotFoundException,
             SQLException {
	 connection = DriverManager.getConnection(url, userName, password);
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 if (null == getEmployee(employee.getId())) {
	     preparedStatement = connection.prepareStatement
                     ("insert into employee values(?, ?, ?, ?, ?, ?)");
             preparedStatement.setInt(1, employee.getId());
	     preparedStatement.setString(2, employee.getName());
	     preparedStatement.setLong(3, employee.getMobile());
             preparedStatement.setDate(4, new java.sql.Date((employee.getDob()).getTime()));
             preparedStatement.setString(5, employee.getDesignation());
	     preparedStatement.setLong(6, employee.getSalary());
	     preparedStatement.executeUpdate();
	 } else {
             return false;  
         }
         return true;   
    }

    /**
     * Methode to delete employee based on employee id
     * @ param id employee id  
     */
     public void deleteEmployee(int id) throws ClassNotFoundException, SQLException {
         connection = DriverManager.getConnection(url, userName, password);
         Class.forName("com.mysql.cj.jdbc.Driver");
         preparedStatement = connection.prepareStatement
                 ("delete from employee where employee_id=?");
         preparedStatement.setInt(1, id);
         preparedStatement.executeUpdate();
     }   
         
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
                    throws ClassNotFoundException, SQLException {
        connection = DriverManager.getConnection(url, userName, password);
        Class.forName("com.mysql.cj.jdbc.Driver");
        if ("name".equals(option)) {
    	   preparedStatement = connection.prepareStatement
                 ("update employee set employee_name = ? where employee_id=?");  
           preparedStatement.setString(1, name);
           preparedStatement.setInt(2, id);
           preparedStatement.executeUpdate();
    	}
    	if ("designation".equals(option)) {
    	   preparedStatement = connection.prepareStatement
                 ("update employee set employee_designation = ? where employee_id=?");  
           preparedStatement.setString(1, designation);
           preparedStatement.setInt(2, id);
           preparedStatement.executeUpdate();
    	}
    	if ("salary".equals(option)) {
    	   preparedStatement = connection.prepareStatement
                 ("update employee set employee_salary = ? where employee_id=?");  
           preparedStatement.setLong(1, salary);
           preparedStatement.setInt(2, id);
           preparedStatement.executeUpdate();
    	}
    	if ("dob".equals(option)) {
    	   preparedStatement = connection.prepareStatement
                 ("update employee set employee_dob = ? where employee_id=?");  
           preparedStatement.setDate(1, new java.sql.Date(dob.getTime()));
           preparedStatement.setInt(2, id); 
           preparedStatement.executeUpdate();
    	}
    	if ("mobile".equals(option)) {
    	   preparedStatement = connection.prepareStatement
                 ("update employee set employee_mobile = ? where employee_id=?");  
           preparedStatement.setLong(1, mobile);
           preparedStatement.setInt(2, id);
           preparedStatement.executeUpdate();
    	}
    } 
}