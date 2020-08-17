package com.mixapp.venitar.exception;

public class InvalidCountryException extends Exception {
    public String invalidCountry = "Invalid Country!!";
    public InvalidCountryException(String s) {
        super(s);
    }
}
