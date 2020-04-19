package com.mixapp.venitar.exception;

public class InvalidLoginException extends Exception {
    private String invalidUser = "Invalid User !!";
    private String wrongCredentials = "You have entered wrong username or password";

    public InvalidLoginException(String s) {
        super(s);
    }
    public String getInvalidUser() {
        return invalidUser;
    }

    public void setInvalidUser(String invalidUser) {
        this.invalidUser = invalidUser;
    }



    public String getWrongCredentials() {
        return wrongCredentials;
    }

    public void setWrongCredentials(String wrongCredentials) {
        this.wrongCredentials = wrongCredentials;
    }


}
