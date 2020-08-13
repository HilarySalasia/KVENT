package com.mixapp.venitar.exception;

public class InvalidCountyException extends Exception {
    private String invalidCounty = "Invalid County!!";
    private String duplCounty = "County already Exists!!";
    public String getInvalidCounty() {
        return invalidCounty;
    }

    public void setInvalidCounty(String invalidCounty) {
        this.invalidCounty = invalidCounty;
    }

    public String getDuplCounty() {
        return duplCounty;
    }

    public void setDuplCounty(String duplCounty) {
        this.duplCounty = duplCounty;
    }


    public InvalidCountyException(String s) {super(s);}
}
