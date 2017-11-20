package com.springapp.mvc;


public class Driver {
    private long id;
    private int clearance;
    private String firstName;
    private String lastName;

    public long getId(){ return id;}
    public void setId(long id){ this.id = id;}

    public int getClearance(){ return clearance;}
    public void setClearance(int clearance){ this.clearance = clearance;}

    public String getFirstName(){ return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName(){ return lastName;}
    public void setLastName(String lastName){this.lastName = lastName;}
}
