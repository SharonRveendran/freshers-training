package com.ideas2it.employeemanagement.model;

/**
 * Calss for address Pojo
 * @author Sharon v 
 * @version 10/03/2021
 */
public class Address {   
    private int employeeId;
    private String doorNumber;
    private String street;
    private String district;
    private String state;
    private String country;
	      
    public Address(int employeeId, String doorNumber, String street, 
            String district, String state, String country) {
        this.employeeId = employeeId;
        this.doorNumber = doorNumber;
        this.street = street;
        this.district = district;
        this.state = state;
        this.country = country;
    }
    
    public void setEmployeeId(int id) {
        this.employeeId = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }
	
    public void setDoorNumber(String doorNumber) {
        this.doorNumber = doorNumber;
    }
	
    public String getDoorNumber() {                    
        return doorNumber;
    }
  
    public void setStreet(String street) {
        this.street = street;
    }
	
    public String getStreet() {
        return street;
    }
    
    public void setDistrict(String district) {
        this.district = district;
    }
	
    public String getDistrict() {
        return district;
    }
    
    public void setState(String state) {
        this.state = state;
    }
	
    public String getState() {
        return state;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
	
    public String getCountry() {
        return country;
    }

    public String toString() {
    	return "\nDoor number   = " + doorNumber
                + "\nStreet        = " + street
                + "\nDistrict      = " + district
                + "\nState         = " + state
                + "\nCountry       = " + country + "\n";
    }
}