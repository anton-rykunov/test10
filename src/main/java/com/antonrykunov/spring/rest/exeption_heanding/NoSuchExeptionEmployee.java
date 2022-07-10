package com.antonrykunov.spring.rest.exeption_heanding;

public class NoSuchExeptionEmployee extends RuntimeException{
    public NoSuchExeptionEmployee(String message) {
        super(message);
    }
}
