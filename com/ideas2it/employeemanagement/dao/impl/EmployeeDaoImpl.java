package com.ideas2it.employeemanagement.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ideas2it.employeemanagement.dao.EmployeeDao;
import com.ideas2it.employeemanagement.model.Employee;
import com.ideas2it.sessionfactory.DatabaseConnection;

/**
 * Class to interact with database
 * @author Sharon V
 * @created 09-03-2021
 */
public class EmployeeDaoImpl implements EmployeeDao {
    DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
    Connection connection = databaseConnection.getDatabaseConnection();	
    PreparedStatement preparedStatement;
    ResultSet resultSet;
      
    /**
     * {@inheritdoc}
     */
    @Override
     public Employee getEmployee(int id) throws SQLException  {
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
     * {@inheritdoc}
     */
    @Override
     public boolean insertEmployee(Employee employee) throws SQLException {
	 if (null == getEmployee(employee.getId())) {
	     preparedStatement = connection.prepareStatement
                     ("insert into employee values(?, ?, ?, ?, ?, ?)");
             preparedStatement.setInt(1, employee.getId());
	     preparedStatement.setString(2, employee.getName());
	     preparedStatement.setLong(3, employee.getMobile());
             preparedStatement.setDate(4, employee.getDob());
             preparedStatement.setString(5, employee.getDesignation());
	     preparedStatement.setLong(6, employee.getSalary());
	     preparedStatement.executeUpdate();
	 } else {
             return false;  
         }
         return true;   
    }

    /**
     * {@inheritdoc}
     */
    @Override
     public void deleteEmployee(int id) throws SQLException {
         preparedStatement = connection.prepareStatement
                 ("delete from employee where employee_id=?");
         preparedStatement.setInt(1, id);
         preparedStatement.executeUpdate();
     }   
         
   /**
     * {@inheritdoc}
     */
    @Override
    public void updateEmployee(int id, String name, String designation,
            long salary, Date dob, long mobile, String option) 
            throws SQLException {
        if ("name".equals(option)) {
    	   preparedStatement = connection.prepareStatement
                 ("update employee set employee_name = ? where employee_id=?");  
           preparedStatement.setString(1, name);
    	}
    	if ("designation".equals(option)) {
    	   preparedStatement = connection.prepareStatement
                 ("update employee set employee_designation = ? where employee_id=?");  
           preparedStatement.setString(1, designation);
    	}
    	if ("salary".equals(option)) {
    	   preparedStatement = connection.prepareStatement
                 ("update employee set employee_salary = ? where employee_id=?");  
           preparedStatement.setLong(1, salary);
    	}
    	if ("dob".equals(option)) {
    	   preparedStatement = connection.prepareStatement
                 ("update employee set employee_dob = ? where employee_id=?");  
           preparedStatement.setDate(1, dob);
    	}
    	if ("mobile".equals(option)) {
    	    updateMobile(mobile);
    	}
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();
    } 

    /**
     * Method to update mobile number
     * @param mobile employee mobile number
     */
    private void updateMobile(long mobile) throws SQLException {
         preparedStatement = connection.prepareStatement
                 ("update employee set employee_mobile = ? where employee_id=?");  
         preparedStatement.setLong(1, mobile);
    }
}