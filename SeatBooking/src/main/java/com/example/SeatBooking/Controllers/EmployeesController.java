package com.example.SeatBooking.Controllers;

import com.example.SeatBooking.Entities.Employees;
import com.example.SeatBooking.Services.EmployeesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.NoSuchElementException;

@RestController

//@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/employees")
public class EmployeesController {
    private EmployeesService employeesService;



    public EmployeesController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @GetMapping
    public List<Employees> getAllEmp(){
        return this.employeesService.getAllEmployees();
    }

    @PostMapping("/add")
    public Employees addEmp(@RequestBody Employees employees){

         return this.employeesService.addEmployees(employees);

    }


    @PostMapping("/login")
    public ResponseEntity<Employees> loginApp(@RequestBody Employees employees) {
        return  this.employeesService.loginEmployee(employees);

    }




    @PutMapping("/{Bems_ID}")
    public ResponseEntity<Employees> updateEmp(@PathVariable Integer Bems_ID,@RequestBody Employees employees){
        try{
            return this.employeesService.updateEmployees(Bems_ID,employees);
        }
        catch (MissingResourceException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{Bems_ID}")
    public ResponseEntity<Employees> deleteEmp(@PathVariable Integer Bems_ID){
        try{
            return this.employeesService.deleteEmployee(Bems_ID);
        }
        catch(MissingResourceException e){
            return ResponseEntity.notFound().build();
        }
    }


  @GetMapping("/name/{bemsId}")
  public ResponseEntity<Map<String, String>> getNameByBemsId(@PathVariable Integer bemsId) {
    try {
      Map<String, String> nameMap = this.employeesService.findNameByBemsId(bemsId);
      return ResponseEntity.ok(nameMap);
    } catch (NoSuchElementException e) {
      return ResponseEntity.notFound().build();
    }
  }


  @GetMapping("/managers")
  public List<Integer> getBemsIdsWithNullManagerAndTeamLead() {
    return this.employeesService.getBemsIdsWithNullManagerAndTeamLead();
  }

  @GetMapping("/team-leads")
  public List<Integer> getBemsIdwithNullTeamlead(){
      return this.employeesService.getBemsIdwithmteamleadnull();
  }

  @GetMapping("/individuals")
  public List<Integer> getAllIndividuals(){
      return this.employeesService.getAllIndividualEmployees();
  }

  @GetMapping("/profile/{bemsId}")
  public ResponseEntity<Map<String, String>> getProfile(@PathVariable Integer bemsId){
    try {
      Map<String, String> nameMap = this.employeesService.findProfileByBemsId(bemsId);
      return ResponseEntity.ok(nameMap);
    } catch (NoSuchElementException e) {
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping("/manager/{managerName}")
  public List<Map<String, String>> getEmployeesByManagerName(@PathVariable String managerName) {
    return this.employeesService.getEmployeesByManagerName(managerName);
  }





}
