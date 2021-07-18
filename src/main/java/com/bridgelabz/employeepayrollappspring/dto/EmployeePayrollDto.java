package com.bridgelabz.employeepayrollappspring.dto;

import java.util.List;

import com.bridgelabz.employeepayrollappspring.model.EmployeePayroll;
import lombok.*;

@Data
@AllArgsConstructor
public class EmployeePayrollDto {
    private String name;
    private String gender;
    private List<String> department;
    private String salary;
    private String startDate;
    private String notes;
    private String profilePic;

    public EmployeePayrollDto(EmployeePayroll user){
        this.name = user.getName();
        this.salary = user.getSalary();
        this.gender = user.getGender();
        this.department = user.getDepartment();
        this.startDate = user.getStartDate();
        this.notes=user.getNotes();
        this.profilePic=user.getProfilePic();
    }

}
