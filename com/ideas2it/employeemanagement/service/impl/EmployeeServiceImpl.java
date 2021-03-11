package com.ideas2it.employeemanagement.service.impl;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.ideas2it.employeemanagement.dao.impl.EmployeeDaoImpl;
import com.ideas2it.employeemanagement.model.Address;
import com.ideas2it.employeemanagement.model.Employee;
import com.ideas2it.employeemanagement.service.EmployeeService;

/**
 * Class for Employee service
 * @author Sharon V
 * @created 09-03-2021
 */
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
    int id = 0;
	
    /**
     * {@inheritdoc}
     */
    @Override
    public int createEmployee(String name, String designation,
            long salary, long mobile, Date dob) throws SQLException {
        id++;
    	Employee employee = new Employee(name, designation, salary, id, mobile, dob);  
        return employeeDao.insertEmployee(employee);
        
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public void createAddress(int employeeId, String addressDetails[], String addressChoice)
            throws SQLException {
       Address employeeAddress = new Address(0, employeeId, addressDetails[0], addressDetails[1],
                addressDetails[2], addressDetails[3], addressDetails[4]); 
       employeeDao.insertAddress(employeeAddress, addressChoice);
    }
    
    /**
     * {@inheritdoc}
     */
    @Override
    public String getEmployee(int id) throws SQLException {
        if (null == employeeDao.getEmployee(id)) {
            return null;
        } else {
            return employeeDao.getEmployee(id);
        }
    }
    
    /**
     * {@inheritdoc}
     */
    @Override
    public void updateEmployee(int id, String name, String designation,
            long salary, Date dob, long mobile, String option)
            throws SQLException {
    	employeeDao.updateEmployee(id, name, designation, salary, dob, mobile, option);
    }
   
    /**
     * {@inheritdoc}
     */
    @Override
    public boolean isIdExist(int id) throws SQLException {
        return employeeDao.isIdExist(id);
    }
     
    /**
     * {@inheritdoc}
     */
    @Override
    public void deleteEmployee(int id) throws SQLException {
    	employeeDao.deleteEmployee(id);
    }
    
    /**
     * {@inheritdoc}
     */
    @Override
    public List<String> getAll() throws SQLException {
        int id = 1; 
        String employeeDetails;
        List<String> employeesDetails = new ArrayList<String>();
        do {
            employeeDetails = employeeDao.getEmployee(id++);
            if (null != employeeDetails) {
                employeesDetails.add(employeeDetails);
            }
        } while (null != employeeDetails);
    	return employeesDetails;
    }
    
    /**
     * {@inheritdoc}
     */
    @Override
    public Date isValidDate(String date) {
    	Date dob = null;
        try {
	    dob = Date.valueOf(date);
        } catch (Exception e) {
            return null;
        }
        return dob;
    }
 
    /**
     * {@inheritdoc}
     */
    @Override
    public long isValidMobile(String input) {
        long mobile;
        if (Pattern.matches("[7-9][0-9]{9}", input)) {
       	    try {
                mobile = Long.parseLong(input); 
            } catch (NumberFormatException e) {
                return 0;
            }
      	} else {
      	   return 0;
      	}
        return mobile;
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public long isValidSalary(String input) {
        long employeeSalary;
        try {
            employeeSalary = Long.parseLong(input);          
        } catch (NumberFormatException e) {
            return 0;
        }
        return employeeSalary;
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public int isValidId(String id) {
        int employeeId;
        try {
 	    employeeId = Integer.parseInt(id); 
    	} catch (NumberFormatException e) {
            return 0;
 	}
        return employeeId;
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public void updateAddress(int addressId, String[] addressDetails) 
            throws SQLException {
        Address employeeAddress = new Address(addressId, 0,  addressDetails[0], addressDetails[1],
                addressDetails[2], addressDetails[3], addressDetails[4]);
        employeeDao.updateAddress(employeeAddress);
    }
}
