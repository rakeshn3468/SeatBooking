package com.example.SeatBooking.Services;


import com.example.SeatBooking.Entities.Admin;
import com.example.SeatBooking.Entities.Employees;
import com.example.SeatBooking.Repositories.AdminRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.MissingResourceException;
import java.util.Optional;

@Service
public class AdminService {
    private AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }


    public List<Admin> getAllAdmin() {
        return this.adminRepository.findAll();
    }

    public Admin addAdmin(Admin admin) {
        return this.adminRepository.save(admin);
    }

    public ResponseEntity<Admin> updateAdmin(Integer bems_id, Admin admin) {
        Optional<Admin> existAdm = this.adminRepository.findById(bems_id);
        if (existAdm.isPresent()){
            Admin toUpdate = existAdm.get();
//            toUpdate.setBems_ID(admin.getBems_ID());
            Admin updated = this.adminRepository.save(toUpdate);
            return ResponseEntity.ok(updated);
        } else{
            throw new MissingResourceException("Not found", Admin.class.getName() , "Bems_ID");
        }
    }

    public ResponseEntity<Admin> deleteAdmin(Integer bems_id) {
        Optional<Admin> exist = this.adminRepository.findById(bems_id);
        if (exist.isPresent()){
            Admin toDelete = exist.get();
            this.adminRepository.delete(toDelete);
            return ResponseEntity.notFound().build();
        } else {
            throw new MissingResourceException("Not found", Admin.class.getName(), "Bems_ID");
        }
    }

  public ResponseEntity<Admin> loginAdmin(Admin admin) {

      Optional<Admin> admOptional=this.adminRepository.findById(admin.getBemsId());
      if(admOptional.isPresent()){
        Admin a=admOptional.get();
        if(a.getPassword().equals(admin.getPassword())){
          return ResponseEntity.ok(a);
        }
      }
    return ResponseEntity.internalServerError().build();
  }
}

