package com.example.SeatBooking.Services;


import com.example.SeatBooking.Entities.Feedback;
import com.example.SeatBooking.Repositories.FeedbackRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.MissingResourceException;
import java.util.Optional;

@Service
public class FeedbackService {
    private FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public List<Feedback> getAllFeedback() {
        return this.feedbackRepository.findAll();
    }

    public Feedback addAllFeedback(Feedback feedback) {
        return this.feedbackRepository.save(feedback);
    }


}
