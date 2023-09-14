package com.msoft.noteappapi.Controller;

import com.msoft.noteappapi.Mail.FeedbackSender;
import com.msoft.noteappapi.Model.Feedback;
import com.msoft.noteappapi.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.xml.bind.ValidationException;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/feedback/api")
public class FeedbackController {
    private FeedbackSender feedbackSender;
    @Autowired
    private FeedbackService feedbackService;

    public FeedbackController(FeedbackSender feedbackSender) {
        this.feedbackSender = feedbackSender;
    }

    @PostMapping("/send/mail")
    public void sendFeedback(@RequestBody Feedback feedback,
                             BindingResult bindingResult) throws ValidationException {
        if(bindingResult.hasErrors()){
            throw new ValidationException("Feedback has errors. Can not send feedback.");
        }
            //send feedback mail
        this.feedbackSender.sendFeedback(
                feedback.getEmail(),
                feedback.getFullName(),
                feedback.getMessage());
            //post feedback to database
        feedbackService.postFeedback(feedback);
    }
}
