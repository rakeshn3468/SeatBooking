package com.example.SeatBooking.Controllers;

import com.example.SeatBooking.Entities.Tower;
import com.example.SeatBooking.Services.TowerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.MissingResourceException;

@RestController
@RequestMapping("/tower")
public class TowerController {
  private TowerService towerService;

  public TowerController(TowerService towerService) {
    this.towerService = towerService;
  }
  @GetMapping
  public List<Tower> getAllTower() { return this.towerService.getTower();}

  @PostMapping("/add")
  public Tower addTow(@RequestBody Tower tower){ return this.towerService.addTower(tower);}

  @PutMapping("/{Tower_Name}")
  public ResponseEntity<Tower> updateTow(@PathVariable String Tower_Name, @RequestBody Tower tower)
  {
    try{
      return this.towerService.updateTower(Tower_Name,tower);
    }
    catch(MissingResourceException e)
    {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{Tower_Name}")
  public ResponseEntity<Tower> deleteTow(@PathVariable String Tower_Name)
  {
    try{
      return this.towerService.deleteTower(Tower_Name);
    }
    catch( MissingResourceException e){
      return ResponseEntity.notFound().build();
    }
  }
}


