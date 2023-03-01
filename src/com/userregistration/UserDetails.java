package com.userregistration;
//Details of user registration
public class UserDetails {
    String firstName;
    String lastName;

    // default constructor
    public UserDetails(){}

    //Constructor with one argument
    public UserDetails(String firstName){
        this.firstName = firstName;
    }

    //Constructor with two arguments
    public UserDetails(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
