package com.rg17.eurekamomentassignment;

public class UserDetails {

    private String userName;
    private String userPhone;
    private String userDob;
    private String userEmail;

    public UserDetails(){

    }

    public UserDetails(String id, String userName, String userPhone, String userDob, String userEmail) {
        this.userName = userName;
        this.userPhone = userPhone;
        this.userDob = userDob;
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public String getUserDob() {
        return userDob;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
