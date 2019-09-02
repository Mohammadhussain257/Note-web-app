package com.msoft.noteappapi.Service.ServiceImpl;

import com.msoft.noteappapi.Model.Feedback;
import com.msoft.noteappapi.Repository.FeedbackRepository;
import com.msoft.noteappapi.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;
    @Override
    public void postFeedback(Feedback feedback) {
        feedbackRepository.save(feedback);
    }
}
