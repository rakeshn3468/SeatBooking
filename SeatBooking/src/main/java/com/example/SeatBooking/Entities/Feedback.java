package com.example.SeatBooking.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Feedback {

    private int Rating;
    @Id
    private String Comments;



    public int getRating() {
        return Rating;
    }

    public void setRating(int rating) {
        Rating = rating;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String comments) {
        Comments = comments;
    }
}
