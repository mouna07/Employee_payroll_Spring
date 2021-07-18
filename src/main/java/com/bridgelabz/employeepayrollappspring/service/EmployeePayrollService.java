package com.bridgelabz.employeepayrollappspring.service;

import com.bridgelabz.employeepayrollappspring.dto.EditDto;
import com.bridgelabz.employeepayrollappspring.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayrollappspring.exception.PayrollException;
import com.bridgelabz.employeepayrollappspring.model.EmployeePayroll;
import com.bridgelabz.employeepayrollappspring.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeePayrollService implements IEmployeePayrollService{

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

    public EmployeePayrollDto CreateUser(EmployeePayrollDto employeePayrollDto){
        EmployeePayroll employeePayroll = new EmployeePayroll(employeePayrollDto);
        return new EmployeePayrollDto(employeePayrollRepository.save(employeePayroll));
    }

  public EmployeePayrollDto UpdateUser(EditDto editDto) {
      Optional<EmployeePayroll> byId = employeePayrollRepository.findById(editDto.getId());
      if (!byId.isPresent()) {
          throw new PayrollException(PayrollException.ExceptionTypes.EMPLOYEE_NOT_FOUND);
      }
      byId.get().setId(editDto.getId());
      byId.get().setName(editDto.getName());
      byId.get().setSalary(editDto.getSalary());
      byId.get().setDepartment(editDto.getDepartment());
      byId.get().setGender(editDto.getGender());
      byId.get().setNotes(editDto.getNotes());
      byId.get().setProfilePic(editDto.getProfilePic());
      return new EmployeePayrollDto(employeePayrollRepository.save(byId.get()));
  }
    public EmployeePayrollDto UpdateUser1(EmployeePayroll editDto) {
        Optional<EmployeePayroll> byId = employeePayrollRepository.findById(editDto.getId());
        if (!byId.isPresent()) {
            throw new PayrollException(PayrollException.ExceptionTypes.EMPLOYEE_NOT_FOUND);
        }
        byId.get().setId(editDto.getId());
        byId.get().setName(editDto.getName());
        byId.get().setSalary(editDto.getSalary());
        byId.get().setDepartment(editDto.getDepartment());
        byId.get().setGender(editDto.getGender());
        byId.get().setNotes(editDto.getNotes());
        byId.get().setProfilePic(editDto.getProfilePic());
        byId.get().setUpdateAt(editDto.getUpdateAt());
        return new EmployeePayrollDto(employeePayrollRepository.save(byId.get()));
    }

  public EmployeePayrollDto deleteUser(UUID id){
    return employeePayrollRepository.findById(id).map(employeePayroll -> {
            employeePayrollRepository.deleteById(employeePayroll.getId());
            return new EmployeePayrollDto(employeePayroll);
        }).orElseThrow(()-> new PayrollException(PayrollException.ExceptionTypes.EMPLOYEE_NOT_FOUND));
    }


    public List<EmployeePayrollDto> getAllUser(){
        return employeePayrollRepository.findAll()
                .stream()
                .map(employeePayroll -> new EmployeePayrollDto(employeePayroll))
                .collect(Collectors.toList());
    }

    public Optional<EmployeePayrollDto> getById(UUID id) {
        Optional<EmployeePayroll> byId= employeePayrollRepository.findById(id);
        EmployeePayroll employeePayroll=byId.get();
        return Optional.of(new EmployeePayrollDto(employeePayroll));
    }

    public Optional<EmployeePayroll> getById1(UUID id) {
        Optional<EmployeePayroll> byId= employeePayrollRepository.findById(id);
        EmployeePayroll employeePayroll=byId.get();
        return Optional.of(new EmployeePayroll(employeePayroll));
    }

    @Override
    public List<EmployeePayroll> getAllUserModel() {
        return employeePayrollRepository.findAll()
                .stream()
                .map(employeePayroll -> new EmployeePayroll(employeePayroll))
                .collect(Collectors.toList());
    }
}