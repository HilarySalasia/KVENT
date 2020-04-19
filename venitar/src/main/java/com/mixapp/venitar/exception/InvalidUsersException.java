package com.mixapp.venitar.exception;

public class InvalidUsersException extends Exception{
    String notfound = "User Not Found!!";
    String dupDirectory = "Duplicate Directory!!";
    String dupUser = "Duplicate User";
    public InvalidUsersException(String s) {
        super(s);
    }

    public String getNotfound() {
        return notfound;
    }

    public String getDupDirectory() {
        return dupDirectory;
    }

    public String getDupUser() {
        return dupUser;
    }
}
