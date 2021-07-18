package com.bridgelabz.employeepayrollappspring.controller;

import com.bridgelabz.employeepayrollappspring.dto.EditDto;
import com.bridgelabz.employeepayrollappspring.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayrollappspring.dto.ResponseDto;
import com.bridgelabz.employeepayrollappspring.exception.PayrollException;
import com.bridgelabz.employeepayrollappspring.model.EmployeePayroll;
import com.bridgelabz.employeepayrollappspring.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("/payroll")
public class UserController {

    @Autowired
    EmployeePayrollService employeePayrollService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createUser(@RequestBody @Valid EmployeePayrollDto user) {
        try {
            EmployeePayrollDto employeePayrollDto = employeePayrollService.CreateUser(user);

            return new ResponseEntity<ResponseDto>(new ResponseDto("User created successfully", "200", employeePayrollDto), HttpStatus.CREATED);
        } catch (PayrollException exception) {
            throw new PayrollException(PayrollException.ExceptionTypes.EMPLOYEE_ALREADY_PRESENT);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateUser(@RequestBody @Valid EditDto user) {
        try {
            EmployeePayrollDto employeePayrollDto = employeePayrollService.UpdateUser(user);
            return new ResponseEntity<ResponseDto>(new ResponseDto("User updated successfully", "200", employeePayrollDto), HttpStatus.OK);
        } catch (PayrollException exception) {
            throw new PayrollException(PayrollException.ExceptionTypes.EMPLOYEE_NOT_FOUND);
        }
    }

    @PutMapping("/updatemodel")
    public ResponseEntity<ResponseDto> updateUser(@RequestBody @Valid EmployeePayroll user) {
        try {
            EmployeePayrollDto employeePayrollDto = employeePayrollService.UpdateUser1(user);
            return new ResponseEntity<ResponseDto>(new ResponseDto("User updated successfully", "200", employeePayrollDto), HttpStatus.OK);
        } catch (PayrollException exception) {
            throw new PayrollException(PayrollException.ExceptionTypes.EMPLOYEE_NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDto> deleteUser(@PathVariable("id") UUID id) {
        try {
            EmployeePayrollDto employeePayrollDto = employeePayrollService.deleteUser(id);
            return new ResponseEntity<ResponseDto>(new ResponseDto("Employee Deleted Successfully", "200", employeePayrollDto), HttpStatus.CREATED);
        } catch (PayrollException exception) {
            throw new PayrollException(PayrollException.ExceptionTypes.EMPLOYEE_NOT_FOUND);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<List<EmployeePayrollDto>> getAllUser() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(employeePayrollService.getAllUser());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/getall")
    public ResponseEntity<List<EmployeePayroll>> getAllUserfrommodel() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(employeePayrollService.getAllUserModel());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<EmployeePayrollDto>> getById(@RequestParam UUID id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(employeePayrollService.getById(id));
        } catch (PayrollException exception) {
            throw new PayrollException(PayrollException.ExceptionTypes.INVALID_USER_ID);
        }
    }

    @GetMapping("/getmodel/{id}")
    public ResponseEntity<Optional<EmployeePayroll>> getById1(@RequestParam UUID id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(employeePayrollService.getById1(id));
        } catch (PayrollException exception) {
            throw new PayrollException(PayrollException.ExceptionTypes.INVALID_USER_ID);
        }
    }
}