package com.ideas2it.employeemanagement.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ideas2it.employeemanagement.dao.EmployeeDao;
import com.ideas2it.employeemanagement.model.Address;
import com.ideas2it.employeemanagement.model.Employee;
import com.ideas2it.sessionfactory.DatabaseConnection;

/**
 * Class to interact with database
 * @author Sharon V
 * @created 09-03-2021
 */
public class EmployeeDaoImpl implements EmployeeDao {
    int addressId = 0;
    DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
    Connection connection = databaseConnection.getDatabaseConnection();	
    PreparedStatement preparedStatement;
    ResultSet resultSet;
  
    /**
     * {@inheritdoc}
     */
    @Override
    public String getEmployee(int id) throws SQLException  {
        int temporaryAddressNumber = 1;
        String employeeDetails = null;
        Address employeeAddress;
	preparedStatement = connection.
                prepareStatement("select * from employee where employee_id=?");
	preparedStatement.setInt(1, id);            
	resultSet = preparedStatement.executeQuery();			         
	if (resultSet.next()) {     
	    Employee employee = new Employee(resultSet.getString(2), resultSet.getString(5),
                    resultSet.getLong(6), id, resultSet.getLong(3), resultSet.getDate(4));
            employeeDetails = employee.toString() + "\nPermanent Address\n-----------------";
            preparedStatement = connection.
                    prepareStatement("select * from address where employee_id=?");
	    preparedStatement.setInt(1, id); 
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {	
                employeeAddress = new Address(resultSet.getInt(1), id, resultSet.getString(3),
                        resultSet.getString(4),resultSet.getString(5), resultSet.getString(6),
                        resultSet.getString(7));
                employeeDetails = employeeDetails + employeeAddress.toString()
                        + "\nTemporary Address " + temporaryAddressNumber + "\n------------------";
                temporaryAddressNumber++;
            }
            return employeeDetails.substring(0,employeeDetails.lastIndexOf('T'));	         
        } else {
	    return null;
	}	      
    }
      
    /**
     * {@inheritdoc}
     */
    @Override
     public int insertEmployee(Employee employee) throws SQLException {
	     preparedStatement = connection.prepareStatement
                     ("insert into employee values(?, ?, ?, ?, ?, ?)");
             preparedStatement.setInt(1, employee.getId());
	     preparedStatement.setString(2, employee.getName());
	     preparedStatement.setLong(3, employee.getMobile());
             preparedStatement.setDate(4, employee.getDob());
             preparedStatement.setString(5, employee.getDesignation());
	     preparedStatement.setLong(6, employee.getSalary());
	     preparedStatement.executeUpdate();
         return employee.getId();   
    }
    
    /**
     * {@inheritdoc}
     */
    @Override
    public void insertAddress(Address employeeAddress, String addressChoice) throws SQLException {
        addressId++;
        preparedStatement = connection.prepareStatement
                ("insert into address values(?, ?, ?, ?, ?, ?, ?, ?)");
        preparedStatement.setInt(1,addressId);
        preparedStatement.setInt(2,employeeAddress.getEmployeeId());
        preparedStatement.setString(3,employeeAddress.getDoorNumber());
        preparedStatement.setString(4,employeeAddress.getStreet());
        preparedStatement.setString(5,employeeAddress.getDistrict());
        preparedStatement.setString(6,employeeAddress.getState());
        preparedStatement.setString(7,employeeAddress.getCountry());
        if("1".equals(addressChoice)) {
            preparedStatement.setString(8,"permanent"); 
        } 
        if("2".equals(addressChoice)) {
            preparedStatement.setString(8,"temporary"); 
        }
        preparedStatement.executeUpdate();
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
         preparedStatement = connection.prepareStatement
                 ("delete from address where employee_id=?");
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
    /**
     * Method to check id present in datrabase or not
     * @param id employee id
     */
    public boolean isIdExist(int id) throws SQLException {
        preparedStatement = connection.prepareStatement
                ("select employee_id from employee where employee_id = ?");
        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public void updateAddress(Address employeeAddress) throws SQLException {
        preparedStatement = connection.prepareStatement
                ("update address set door_number = ?, street = ?, district = ?,"
                + "state = ?,country = ? where address_id = ?");
        preparedStatement.setString(1,employeeAddress.getDoorNumber());
        preparedStatement.setString(2,employeeAddress.getStreet());
        preparedStatement.setString(3,employeeAddress.getDistrict());
        preparedStatement.setString(4,employeeAddress.getState());
        preparedStatement.setString(5,employeeAddress.getCountry());
        preparedStatement.setInt(6,employeeAddress.getAddressId());
        preparedStatement.executeUpdate();   
    }
}