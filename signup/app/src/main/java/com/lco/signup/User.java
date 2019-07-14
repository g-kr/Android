package com.lco.signup;

public class User {
    public String username;
    public String email;
    public String Phone;
//    public String id;
//    public String dob;
//    public String address;
//    public String postalcode;
//    public String city;


    public User(String username,String Email,String Phone) {
        this.username=username;
        //this.id=id;
        this.Phone=Phone;
        this.email=Email;
//        this.dob=DOB;
//        this.city=City;
//        this.address=Address;
//        this.postalcode=Postalcode;
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }



}
