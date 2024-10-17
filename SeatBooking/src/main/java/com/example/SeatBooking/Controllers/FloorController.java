package com.example.SeatBooking.Controllers;

import com.example.SeatBooking.Entities.Floor;
import com.example.SeatBooking.Services.FloorService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.MissingResourceException;

@RestController
@RequestMapping("/floor")
public class FloorController {
  private FloorService floorService;

  public FloorController(FloorService floorService) {
    this.floorService = floorService;
  }
  @GetMapping
  public List<Floor> getAllFloor() { return this.floorService.getFloors();}

  @PostMapping("/add")
  public Floor addAllFloor(@RequestBody Floor floor){ return this.floorService.addFloor(floor);}

  @PutMapping("/{Floor_Number}")
  public ResponseEntity<Floor> updateFloor(@PathVariable Integer Floor_Number, @RequestBody Floor floor)
  {
    try{
      return this.floorService.updateAllFloor(Floor_Number, floor);
    }
    catch (MissingResourceException e)
    {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{Floor_Number}")
  public ResponseEntity<Floor> deleteFloor(@PathVariable Integer Floor_Number)
  {
    try{
      return this.floorService.deleteAllFloor(Floor_Number);
    }
    catch (MissingResourceException e){
      return ResponseEntity.noContent().build();
    }
  }
}


