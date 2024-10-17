package com.example.SeatBooking.Controllers;


import com.example.SeatBooking.Entities.Admin;
import com.example.SeatBooking.Entities.Employees;
import com.example.SeatBooking.Services.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.MissingResourceException;

@RestController

@RequestMapping("/admin")
public class AdminController {
    private AdminService adminService;


    public AdminController(AdminService adminService){
        this.adminService=adminService;
    }


    @GetMapping
    public List<Admin> getAllAdm(){
        return this.adminService.getAllAdmin();
    }

    @PostMapping("/add")
    public Admin addAdm(@RequestBody Admin admin){
        return this.adminService.addAdmin(admin);
    }

    @PostMapping("/login")
    public ResponseEntity<Admin> loginAdmin(@RequestBody Admin admin){
      return this.adminService.loginAdmin(admin);
    }



    @PutMapping("{Bems_ID}")
    public ResponseEntity<Admin> updateAdm(@PathVariable Integer Bems_ID , @RequestBody Admin admin){
        try{
            return this.adminService.updateAdmin(Bems_ID, admin);
        }
        catch(MissingResourceException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{Bems_ID}")
    public ResponseEntity<Admin> deleteAdm(@PathVariable Integer Bems_ID){
        try {
            return this.adminService.deleteAdmin(Bems_ID);
        }
        catch (MissingResourceException e){
            return ResponseEntity.notFound().build();
        }

    }
}
