package com.example.SeatBooking.Services;


import com.example.SeatBooking.Entities.Tower;
import com.example.SeatBooking.Repositories.TowerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.MissingResourceException;
import java.util.Optional;

@Service
public class TowerService {
  private TowerRepository towerRepository;

  public TowerService(TowerRepository towerRepository) {
    this.towerRepository = towerRepository;
  }

  public List<Tower> getTower() {
    return this.towerRepository.findAll();
  }

  public Tower addTower(Tower tower) {
    return this.towerRepository.save(tower);
  }


  public ResponseEntity<Tower> updateTower(String Tower_Name, Tower tower) {
    Optional<Tower> existTower = Optional.ofNullable(this.towerRepository.findByTowerName(Tower_Name));
    if(existTower.isPresent())
    {
      Tower toUpdate = existTower.get();
      toUpdate.setTowerName(tower.getTowerName());
      Tower updated = this.towerRepository.save(toUpdate);
      return ResponseEntity.ok(updated);
    }
    else {
      throw new MissingResourceException("Not Found",Tower.class.getName(),"Tower_Name");
    }
  }


  public ResponseEntity<Tower> deleteTower(String  Tower_Name) {
    Optional<Tower> exist = Optional.ofNullable(this.towerRepository.findByTowerName(Tower_Name));
    if(exist.isPresent()){
      Tower toDelete = exist.get();
      this.towerRepository.delete(toDelete);
      return ResponseEntity.noContent().build();
    }
    else{
      throw new MissingResourceException("Not Found",Tower.class.getName(),"Tower_Name");
    }
  }
}


