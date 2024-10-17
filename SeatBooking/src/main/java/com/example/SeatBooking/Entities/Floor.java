package com.example.SeatBooking.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Floor {
  @Id
  private int Floor_Number;


  public int getFloor_Number() {
    return Floor_Number;
  }

  public void setFloor_Number(int floor_Number) {
    Floor_Number = floor_Number;
  }


}


