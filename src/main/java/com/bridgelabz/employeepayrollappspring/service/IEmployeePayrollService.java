package com.bridgelabz.employeepayrollappspring.service;

import com.bridgelabz.employeepayrollappspring.dto.EditDto;
import com.bridgelabz.employeepayrollappspring.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayrollappspring.model.EmployeePayroll;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IEmployeePayrollService {

    EmployeePayrollDto CreateUser(EmployeePayrollDto employeePayrollDto);

    EmployeePayrollDto UpdateUser(EditDto editDto);

    EmployeePayrollDto UpdateUser1(EmployeePayroll editDto);

    EmployeePayrollDto deleteUser(UUID id);

    List<EmployeePayrollDto> getAllUser();

    Optional<EmployeePayrollDto> getById(UUID id);

    Optional<EmployeePayroll> getById1(UUID id);

    List<EmployeePayroll> getAllUserModel();
}
