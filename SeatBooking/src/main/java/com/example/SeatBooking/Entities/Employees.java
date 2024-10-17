package com.example.SeatBooking.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

public class Employees {
    @Id
    @Column(name = "Bems_ID")
    private int bemsId;
    private String First_Name;
    private String Last_Name;
    private String Email;
    private String Password;

    private String Confirm_Password;

    public String getConfirm_Password() {
        return Confirm_Password;
    }

    public void setConfirm_Password(String confirm_Password) {
        Confirm_Password = confirm_Password;
    }

    private String teamLeadName;

    private String managerName;

  public int getBemsId() {
    return bemsId;
  }

  public void setBemsId(int bemsId) {
    this.bemsId = bemsId;
  }

  public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String first_Name) {
        First_Name = first_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String last_Name) {
        Last_Name = last_Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

  public String getTeamLeadName() {
    return teamLeadName;
  }

  public void setTeamLeadName(String teamLeadName) {
    this.teamLeadName = teamLeadName;
  }

  public String getManagerName() {
    return managerName;
  }

  public void setManagerName(String managerName) {
    this.managerName = managerName;
  }
}

