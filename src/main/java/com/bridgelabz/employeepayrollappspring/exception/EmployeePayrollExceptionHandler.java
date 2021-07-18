package com.bridgelabz.employeepayrollappspring.exception;

import com.bridgelabz.employeepayrollappspring.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class EmployeePayrollExceptionHandler {
    @ExceptionHandler(PayrollException.class)
    public ResponseEntity<ResponseDto> handleCMSException(PayrollException payrollException){
        return new ResponseEntity<ResponseDto>(new ResponseDto(null,null, payrollException.exceptionTypes.errorMessage),
                HttpStatus.BAD_REQUEST);
    }
}
