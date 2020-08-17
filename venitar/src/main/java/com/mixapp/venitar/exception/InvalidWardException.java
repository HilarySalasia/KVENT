package com.mixapp.venitar.exception;

public class InvalidWardException extends Exception {
    public String duplWard = "Ward Already Exists..";
    public String invalidWard = "Invalid Ward!!";
    public InvalidWardException(String s) {super(s);}
}
