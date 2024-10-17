package com.example.SeatBooking.Services;

import com.example.SeatBooking.Entities.Employees;
import com.example.SeatBooking.Repositories.EmployeesRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeesService {
    private EmployeesRepository employeesRepository;

    public EmployeesService(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    public List<Employees> getAllEmployees() {
        return this.employeesRepository.findAll();
    }

    public Employees addEmployees(Employees employees) {
        return this.employeesRepository.save(employees);
    }

    public ResponseEntity<Employees> loginEmployee(Employees employees) {
        Optional<Employees> empOptional = this.employeesRepository.findById(employees.getBemsId());
        if (empOptional.isPresent()) {
            Employees emp = empOptional.get();
            if (emp.getPassword().equals(employees.getPassword())) {
                return ResponseEntity.ok(emp);
            }
        }
        return ResponseEntity.internalServerError().build();
    }



    public ResponseEntity<Employees> updateEmployees(Integer bemsId, Employees employees) {
        Optional<Employees> existEmp = this.employeesRepository.findById(bemsId);
        if (existEmp.isPresent()) {
            Employees toUpdate = existEmp.get();
            toUpdate.setFirst_Name(employees.getFirst_Name());
            toUpdate.setLast_Name(employees.getLast_Name());
            toUpdate.setManagerName(employees.getManagerName());
            toUpdate.setTeamLeadName(employees.getTeamLeadName());
            toUpdate.setEmail(employees.getEmail());
            Employees updated = this.employeesRepository.save(toUpdate);
            return ResponseEntity.ok(updated);
        } else {
            throw new MissingResourceException("Not found", Employees.class.getName(), "Bems_ID");
        }
    }


    public ResponseEntity<Employees> deleteEmployee(Integer bemsId) {
        Optional<Employees> exist = this.employeesRepository.findById(bemsId);
        if (exist.isPresent()) {
            Employees toDelete = exist.get();
            this.employeesRepository.delete(toDelete);
            return ResponseEntity.noContent().build();
        } else {
            throw new MissingResourceException("Not found", Employees.class.getName(), "Bems_ID");
        }
    }


  public Map<String, String> findNameByBemsId(Integer bemsId) {
    Optional<Employees> empOptional = this.employeesRepository.findByBemsId(bemsId);

    if (empOptional.isPresent()) {
      Employees emp = empOptional.get();

      Map<String, String> nameMap = new HashMap<>();
      nameMap.put("first_name", emp.getFirst_Name());
      nameMap.put("last_name", emp.getLast_Name());

      return nameMap;
    } else {
      throw new NoSuchElementException("No user found with bems_id: " + bemsId);
    }
  }

  public List<Integer> getBemsIdsWithNullManagerAndTeamLead() {
    List<Employees> employees = this.employeesRepository.findByManagerNameIsNullAndTeamLeadNameIsNull();

    List<Integer> bemsIds = new ArrayList<>();
    for (Employees employee : employees) {
      bemsIds.add(employee.getBemsId());
    }

    return bemsIds;
  }

  public List<Integer> getBemsIdwithmteamleadnull() {
      List<Employees> employees = this.employeesRepository.findByTeamLeadNameIsNull();
      List<Integer> bemsIds= new ArrayList<>();
      for(Employees employee:employees){
        bemsIds.add(employee.getBemsId());
      }
      return bemsIds;
  }

  public List<Integer> getAllIndividualEmployees() {
    List<Employees> employees =this.employeesRepository.findByManagerNameIsNotNullAndTeamLeadNameIsNotNull();
    List<Integer> bemsId=new ArrayList<>();
    for(Employees e:employees){
      bemsId.add(e.getBemsId());
    }
    return bemsId;
  }

  public Map<String, String> findProfileByBemsId(Integer bemsId) {
    Optional<Employees> empOptional = this.employeesRepository.findByBemsId(bemsId);
    if (empOptional.isPresent()) {
      Employees emp = empOptional.get();

      Map<String, String> nameMap = new HashMap<>();
      nameMap.put("first_name", emp.getFirst_Name());
      nameMap.put("last_name", emp.getLast_Name());
      if(emp.getManagerName() != null){nameMap.put("Manager_Name",emp.getManagerName());}
      if(emp.getTeamLeadName()!=null){nameMap.put("TeamLead_Name", emp.getTeamLeadName());}
      nameMap.put("Email",emp.getEmail());
      nameMap.put("Password",emp.getPassword());
//      nameMap.put("Bems Id",emp.getBemsId());

      return nameMap;
    } else {
      throw new NoSuchElementException("No user found with bems_id: " + bemsId);
    }
  }

  public List<Map<String, String>> getEmployeesByManagerName(String managerName) {
    List<Employees> employeesList = employeesRepository.findByManagerName(managerName);

    List<Map<String, String>> result = new ArrayList<>();

    for (Employees employee : employeesList) {
      Map<String, String> employeeInfo = new HashMap<>();
//      employeeInfo.put("bems_id", employee.getBemsId().toString());
      employeeInfo.put("first_name", employee.getFirst_Name());
      employeeInfo.put("last_name", employee.getLast_Name());
      employeeInfo.put("email", employee.getEmail());
      result.add(employeeInfo);
    }

    return result;
  }


}

