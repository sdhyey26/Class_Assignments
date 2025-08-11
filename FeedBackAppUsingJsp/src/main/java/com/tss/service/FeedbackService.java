package com.tss.service;

import com.tss.dao.FeedbackDAO;
import com.tss.exception.InvalidFeedbackException;
import com.tss.model.Feedback;

public class FeedbackService {
    public void validateAndSave(Feedback fb) throws Exception {
        if (fb.getName() == null || fb.getName().trim().isEmpty()) {
            throw new InvalidFeedbackException("Name is required.");
        }

        validateScore(fb.getSessionContent(), "Session Content");
        validateScore(fb.getQueryFeedback(), "Query Resolution/Feedback");
        validateScore(fb.getInteractivity(), "Interactivity/Engagement");
        validateScore(fb.getImpactfulLearning(), "Impactful Learning");
        validateScore(fb.getDeliverySkills(), "Content Delivery Skills");

        new FeedbackDAO().saveFeedback(fb);
    }

    private void validateScore(int value, String fieldName) throws InvalidFeedbackException {
        if (value < 1 || value > 10) {
            throw new InvalidFeedbackException(fieldName + " must be between 1 and 10.");
        }
    }
}
