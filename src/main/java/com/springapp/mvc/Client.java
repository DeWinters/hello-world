package com.springapp.mvc;

/**
 * Created by Administrator on 07/12/2016.
 */
public class Client {

    private long id;
    private String firstName;
    private String lastName;

    public long getId(){ return id;}
    public void setId(long id){ this.id = id;}

    public String getFirstName(){ return firstName;}
    public void setFirstName(String name){ this.firstName = name;}

    public String getLastName(){ return lastName;}
    public void setLastName(String name){ this.lastName = name;}

}
