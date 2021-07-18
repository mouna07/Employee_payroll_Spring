package com.bridgelabz.employeepayrollappspring.repository;

import com.bridgelabz.employeepayrollappspring.model.EmployeePayroll;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayroll, UUID> {
}