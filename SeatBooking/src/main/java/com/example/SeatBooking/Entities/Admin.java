package com.example.SeatBooking.Entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
    @Id
    @Column(name = "Bems_ID")
    private int bemsId;
    private String Password;

  public int getBemsId() {
    return bemsId;
  }

  public void setBemsId(int bemsId) {
    this.bemsId = bemsId;
  }

  public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
