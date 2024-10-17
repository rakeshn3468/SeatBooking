package com.example.SeatBooking.Controllers;


import com.example.SeatBooking.Entities.Feedback;
import com.example.SeatBooking.Services.FeedbackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.MissingResourceException;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    private FeedbackService feedbackService;


    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping
    public List<Feedback> getAllFeed() {
        return this.feedbackService.getAllFeedback();
    }

    @PostMapping("/add")
    public Feedback addFeed(@RequestBody Feedback feedback) {
        return this.feedbackService.addAllFeedback(feedback);
    }


}

