package com.example.imoshikasewwandi.styleomegaassignment.MODEL_user;

/**
 * Created by Imoshika Sewwandi on 8/28/2017.
 */

public class User {
    private int ID;
    private String u_fname;
    private String u_lname;
    private String u_email;
    private String u_password;
    private String username;
    private String contact;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getU_fname() {
        return u_fname;
    }

    public void setU_fname(String u_name) {
        this.u_fname = u_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getU_email() {
        return u_email;
    }

    public void setU_email(String u_email) {
        this.u_email = u_email;
    }

    public String getU_password() {
        return u_password;
    }

    public void setU_password(String u_password) {
        this.u_password = u_password;
    }

    public String getU_lname() {
        return u_lname;
    }

    public void setU_lname(String u_lname) {
        this.u_lname = u_lname;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
