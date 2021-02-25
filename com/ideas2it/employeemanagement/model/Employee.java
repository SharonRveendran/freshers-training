package com.ideas2it.employeemanagement.model;

/**
 * POJO class for employee providing id,
 * name, designation & salary. 
 * @author Sharon
 * @created 23-02-2021
 */
public class Employee {
    private String name;
    private String designation;
    private int id;
    private long salary;
    public Employee(String name, String designation, long salary) {
    	this.name = name;
    	this.designation = designation;
    	this.salary = salary;
	}

    public String toString() {
    	return "Employee Id = " + id + " , Employee Name = " +
        	name + " , Employee Designation = " + designation
    	        + " , Employee Salary = " + salary;
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
}

