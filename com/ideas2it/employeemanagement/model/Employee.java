package com.ideas2it.employeemanagement.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * POJO class for employee providing id,
 * name, designation & salary. 
 * @author Sharon
 * @created 01-03-2021
 */
public class Employee {
    private int id;
    private String name;
    private Date dob;
    private long mobile;
    private String designation;
    private long salary;  
    
    public Employee(String name, String designation,
    		long salary, int id, long mobile, Date dob) {
    	this.id = id;
        this.name = name;
        this.dob = dob;
        this.mobile = mobile; 
    	this.designation = designation;
    	this.salary = salary; 	
    }
 
    public int getId() {
	return id;
    }
    
    public void setId(int id) {
	this.id = id;
    }
    
    public String getName() {
	return name;
    }
    
    public void setName(String name) {
	this.name = name;
    }

    public Date getDob() {
	return dob;
    }

    public void setDob(Date dob) {
	this.dob = dob;
    }

    public long getMobile() {
	return mobile;
    }

    public void setMobile(long mobile) {
	this.mobile = mobile;
    }  
	
    public String getDesignation() {
	return designation;
    }
	
    public void setDesignation(String designation ) {
	this.designation = designation;
    }
		
    public long getSalary() {
	return salary;
    }
	
    public void setSalary(long salary) {
	this.salary = salary;
    } 
	
    public String toString() {
    	return "\nEmployee Id             =  " + id + "\nEmployee Name           =  "
                + name + "\nEmployee Designation    =  " + designation
    		+ "\nEmployee Salary         =  " + salary
    		+"\nEmployee Mobile         =  " + mobile + "\nEmployee Date of Birth  =  "
    		+ new SimpleDateFormat("dd/mm/yyy").format(dob) + "\n";
    }
}
