package com.ideas2it.employeemanagement.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.ideas2it.employeemanagement.model.Employee;
import com.ideas2it.employeemanagement.dao.impl.EmployeeDaoImpl;

/**
 * Class for Employee service
 * @author Sharon V
 * @created 08-03-2021
 */
public class EmployeeService {
    Map<Integer, Employee> employees = new HashMap<Integer, Employee>();
    EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
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
            ,long salary, long mobile, Date dob) throws ClassNotFoundException, SQLException {
        id++;
    	Employee employee = new Employee(name, designation, salary, id, mobile, dob);
        return employeeDao.insertEmployee(employee);
    }
    
    /**
     * Method to return employee details based on employee id
     * @param id Employee id
     * @return employee object if employee present else return null
     */
    public String getEmployee(int id) throws ClassNotFoundException, SQLException {
        if (null == employeeDao.getEmployee(id)) {
            return null;
        } else {
            return (employeeDao.getEmployee(id)).toString();
        }
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
    	employeeDao.updateEmployee(id, name, designation, salary, dob, mobile, option);
    }
   
    /**
     * Method to check whether the id is present in collection or not 
     * @param id Employee id
     * @return true if id present in collection else return false
     */
    public boolean isIdExist(int id) throws ClassNotFoundException, SQLException {
        return ((null == employeeDao.getEmployee(id)) ? false : true);
    }
     
    /**
     * Method to delete the Employee based on employee id
     * @param id Employee id
     */
    public void deleteEmployee(int id) throws ClassNotFoundException, SQLException {
    	employeeDao.deleteEmployee(id);
    }
    
    /**
     * Method to return all employee details present in collection
     * @return list of employee details
     */
    public List<String> getAll() throws SQLException, ClassNotFoundException {
        int id = 1; 
        Employee employee;
        List<String> employeeDetails = new ArrayList<String>();
        do {
            employee = employeeDao.getEmployee(id++);
            if (null != employee) {
                employeeDetails.add(employee.toString());
            }
        } while (null != employee);
    	return employeeDetails;
    }
    
    /**
     * Method to validate date
     * @param date
     * @return valid date
     */
    public Date isValidDate(String date) {
    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    	Date dob = null;
        try {
	    dob = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            return null;
        }
        return dob;
    }
 
    /**
     * Methode to validate mobile number
     * @param input user given input for mobile
     * @return valid mobile number
     */
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
     * This methode will validate employee salary
     * @param input user given input for salary
     * @return valid employee salary
     */
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
     * This method will validate employee id
     * @param id employee id
     * @return valid employee id
     */
    public int isValidId(String id) {
        int employeeId;
        try {
 	    employeeId = Integer.parseInt(id); 
    	} catch (NumberFormatException e) {
            return 0;
 	}
        return employeeId;
    }
}
