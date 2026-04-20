package com.handmade.shop.controller;

import com.handmade.shop.dto.FeedbackRequest;
import com.handmade.shop.model.Feedback;
import com.handmade.shop.service.FeedbackService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping
    public String add(@RequestBody FeedbackRequest request){
        return feedbackService.addFeedback(request);
    }

    @GetMapping
    public List<Feedback> getAll(){
        return feedbackService.getAll();
    }
}