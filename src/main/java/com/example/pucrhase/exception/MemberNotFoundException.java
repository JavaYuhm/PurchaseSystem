package com.example.pucrhase.exception;

public class MemberNotFoundException extends RuntimeException {
    public MemberNotFoundException(String error){
        super(error);
    }
}
