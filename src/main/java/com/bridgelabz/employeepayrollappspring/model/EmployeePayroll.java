package com.bridgelabz.employeepayrollappspring.model;

import com.bridgelabz.employeepayrollappspring.dto.EmployeePayrollDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table
public class EmployeePayroll implements Serializable {


    @Id
    @GeneratedValue(generator = "uuid2",strategy = GenerationType.AUTO)
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "uuid-char")
    private UUID id;

    private String name;
    private String gender;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(joinColumns = @JoinColumn(name = "id"))
    private List<String> department;
    private String salary;
    private String startDate;
    private String notes;
    private String profilePic;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updateAt;


    public EmployeePayroll(EmployeePayrollDto employeePayrollDto) {
        this.name = employeePayrollDto.getName();
        this.gender = employeePayrollDto.getGender();
        this.department = employeePayrollDto.getDepartment();
        this.notes = employeePayrollDto.getNotes();
        this.startDate = employeePayrollDto.getStartDate();
        this.salary = employeePayrollDto.getSalary();
        this.profilePic = employeePayrollDto.getProfilePic();
    }

    public EmployeePayroll(EmployeePayroll employeePayroll) {
        this.id = employeePayroll.getId();
        this.name = employeePayroll.getName();
        this.gender = employeePayroll.getGender();
        this.department = employeePayroll.getDepartment();
        this.notes =employeePayroll.getNotes();
        this.startDate = employeePayroll.getStartDate();
        this.salary = employeePayroll.getSalary();
        this.profilePic = employeePayroll.getProfilePic();
        this.updateAt = employeePayroll.getUpdateAt();
        this.createdAt = employeePayroll.getCreatedAt();
    }
}
