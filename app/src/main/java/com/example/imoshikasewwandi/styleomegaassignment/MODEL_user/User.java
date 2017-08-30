package com.example.imoshikasewwandi.styleomegaassignment.MODEL_user;

/**
 * Created by Imoshika Sewwandi on 8/28/2017.
 */

public class User {
    private int ID;
    private String u_name;
    private String u_email;
    private String u_password;
    private String username;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
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
}
