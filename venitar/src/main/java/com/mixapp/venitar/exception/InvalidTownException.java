package com.mixapp.venitar.exception;

public class InvalidTownException extends Exception {
    public String duplTown = "Town Already Exists";
    public String invalidTown = "Invalid Town!!";
    public InvalidTownException(String s) {super(s);}
}
