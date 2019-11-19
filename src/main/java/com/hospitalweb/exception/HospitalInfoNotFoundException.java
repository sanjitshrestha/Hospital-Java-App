package com.hospitalweb.exception;

public class HospitalInfoNotFoundException extends Exception {
    private long id;
    public HospitalInfoNotFoundException(long id) {
        super(String.format("Hospital is not found with id : '%s'", id));
    }
}
