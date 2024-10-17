package com.example.SeatBooking.Entities;


import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
public class Booking {

    @Column(name = "Seat_ID")
    private Integer seatId;

    @Column(name="Tower_Name")
    private String towerName;

    @Column(name = "Floor_Number")

    private Integer floorNumber;

    private int bemsId;

    @Column(name = "Duration")
    private int duration;

    @Column(name = "Availability_Status")
    private Boolean availabilityStatus;


    @Column(name = "Booking_date")
    private Date booking_date;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Booking_ID;

    @Column(name = "To_date")
    private Date to_date;


  public int getBemsId() {
    return bemsId;
  }

  public void setBemsId(int bemsId) {
    this.bemsId = bemsId;
  }



  public Integer getSeatId() {
    return seatId;
  }

  public void setSeatId(Integer seatId) {
    this.seatId = seatId;
  }

  public Boolean getAvailabilityStatus() {
    return availabilityStatus;
  }

  public void setAvailabilityStatus(Boolean availabilityStatus) {
    this.availabilityStatus = availabilityStatus;
  }

  public String getTowerName() {
    return towerName;
  }

  public void setTowerName(String towerName) {
    this.towerName = towerName;
  }

  public Integer getFloorNumber() {
    return floorNumber;
  }

  public void setFloorNumber(Integer floorNumber) {
    this.floorNumber = floorNumber;
  }

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public Date getBooking_date() {
    return booking_date;
  }

  public void setBooking_date(Date booking_date) {
    this.booking_date = booking_date;
  }

  public int getBooking_ID() {
    return Booking_ID;
  }

  public void setBooking_ID(int booking_ID) {
    Booking_ID = booking_ID;
  }

  public Date getTo_date() {
    return to_date;
  }

  public void setTo_date(Date to_date) {
    this.to_date = to_date;
  }
}
