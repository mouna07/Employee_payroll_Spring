package com.bridgelabz.employeepayrollappspring.exception;

public class PayrollException extends RuntimeException{
    public ExceptionTypes exceptionTypes;

    public PayrollException(ExceptionTypes exceptionTypes){
        this.exceptionTypes = exceptionTypes;
    }

    public enum ExceptionTypes{
        EMPLOYEE_NOT_FOUND("Invalid Data.. Employee not found"),
        EMPLOYEE_ALREADY_PRESENT("Employee Already Present"),
        INVALID_USER_ID("user id you have given is incorrect"),
        EMPLOYEE_NOT_PRESENT("employee is not present in database");
        public String errorMessage;

        ExceptionTypes(String errorMessage) {
            this.errorMessage = errorMessage;
        }
    }

}
