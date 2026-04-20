package com.handmade.shop.service;

import com.handmade.shop.dto.FeedbackRequest;
import com.handmade.shop.model.Feedback;
import com.handmade.shop.repository.FeedbackRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public String addFeedback(FeedbackRequest request){

        Feedback fb = new Feedback();
        fb.setUsername(request.getUsername());
        fb.setMessage(request.getMessage());

        feedbackRepository.save(fb);

        return "Feedback submitted";
    }

    public List<Feedback> getAll(){
        return feedbackRepository.findAll();
    }
}