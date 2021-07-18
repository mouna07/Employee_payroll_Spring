package com.bridgelabz.employeepayrollappspring.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class EditDto extends EmployeePayrollDto{
    UUID id;


    public EditDto(  String name, String gender, List<String> department, String salary, String startDate, String notes, String profilePic) {
        super(name, gender, department, salary, startDate, notes, profilePic);
    }
}
