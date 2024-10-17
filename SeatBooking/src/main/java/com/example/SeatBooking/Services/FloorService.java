package com.example.SeatBooking.Services;

import com.example.SeatBooking.Entities.Floor;
import com.example.SeatBooking.Repositories.FloorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.MissingResourceException;
import java.util.Optional;

@Service
public class FloorService {
  private FloorRepository floorRepository;

  public FloorService(FloorRepository floorRepository) {
    this.floorRepository = floorRepository;
  }


  public List<Floor> getFloors() {
    return this.floorRepository.findAll();
  }


  public Floor addFloor(Floor floor) {
    return this.floorRepository.save(floor);
  }


  public ResponseEntity<Floor> updateAllFloor(Integer Floor_Number, Floor floor) {
    Optional<Floor> existFloor = this.floorRepository.findById(Floor_Number);
    if(existFloor.isPresent()){
      Floor toUpdate = existFloor.get();
      toUpdate.setFloor_Number(floor.getFloor_Number());
//      toUpdate.setTower_Name(floor.getTower_Name());
      Floor updated = this.floorRepository.save(toUpdate);
      return ResponseEntity.ok(updated);
    }
    else{
      throw new MissingResourceException("Not Found",Floor.class.getName(),"Floor_Number");
    }
  }


  public ResponseEntity<Floor> deleteAllFloor(Integer Floor_Name) {
    Optional<Floor> exist = this.floorRepository.findById(Floor_Name);
    if(exist.isPresent())
    {
      Floor toDelete = exist.get();
      this.floorRepository.delete(toDelete);
      return ResponseEntity.noContent().build();
    }
    else {
      throw new MissingResourceException("Not Found",Floor.class.getName(),"Floor_Number");
    }
  }
}


