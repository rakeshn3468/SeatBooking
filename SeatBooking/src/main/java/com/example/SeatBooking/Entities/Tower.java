package com.example.SeatBooking.Entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tower {
  @Id
  @Column(name = "Tower_Name")
  private String towerName;

//  private String attributeName;


  public String getTowerName() {
    return towerName;
  }

  public void setTowerName(String towerName) {
    this.towerName = towerName;
  }
}


