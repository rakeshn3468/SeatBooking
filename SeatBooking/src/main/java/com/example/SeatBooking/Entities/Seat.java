package com.example.SeatBooking.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Seat {

  @Id
  private int Seat_ID;
  private char Floor_Number;

  public int getSeat_ID() {
    return Seat_ID;
  }

  public void setSeat_ID(int seat_ID) {
    Seat_ID = seat_ID;
  }

  public char getFloor_Number() {
    return Floor_Number;
  }

  public void setFloor_Number(char floor_Number) {
    Floor_Number = floor_Number;
  }

}
