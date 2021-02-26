package com.ideas2it.employeemanagement.model;

import java.util.Date;

/**
 * POJO class for employee providing id,
 * name, designation & salary. 
 * @author Sharon
 * @created 23-02-2021
 */
public class Employee {
    private int id;
    private String name;
    private String designation;
    private long salary;
    private long mobile;
    private String dob;
    
    public Employee(String name, String designation, long salary, int id, long mobile, String dob) {
    	this.name = name;
    	this.designation = designation;
    	this.salary = salary;
    	this.id = id;
    	this.mobile = mobile;
    	this.dob = dob;
    }

    public String toString() {
    	return "\nEmployee Id          =  " + id + "\nEmployee Name        =  "
        	+ name + "\nEmployee Designation =  " + designation
    	        + "\nEmployee Salary      =  " + salary
    	        +"\nMobile               =  " + mobile + "\nDate of Birth        =  " + dob + "\n";
    }
    
    public String getName() {
		return name;
    }
    
    public void setName(String name) {
		this.name = name;
    }
	
    public String getDesignation() {
		return designation;
    }
	
    public void setDesignation(String designation ) {
		this.designation = designation;
    }
	
    public int getId() {
		return id;
    }
	
    public void setId(int id) {
		this.id = id;
    }
	
    public long getSalary() {
		return salary;
    }
	
    public void setSalary(int salary) {
		this.salary = salary;
    } 
	
    public void setMobile(long mobile) {
		this.mobile = mobile;
    }
	
    public long getMobile() {
		return mobile;
    }
	
    public void setDob(String dob) {
		this.dob = dob;
    }
	
    public String getDob() {
		return dob;
    }
}