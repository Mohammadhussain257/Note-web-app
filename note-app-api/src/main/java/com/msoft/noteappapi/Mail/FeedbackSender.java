package com.msoft.noteappapi.Mail;

public interface FeedbackSender {
    void sendFeedback(String from, String name, String feedback);
}
