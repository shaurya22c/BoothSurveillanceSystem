package com.project.dao;

import java.util.List;

import com.project.model.FeedbackVO;

public interface FeedbackDAO {

	void insertFeedback(FeedbackVO feedbackVO);

	public List viewFeedback(FeedbackVO feedbackVO);

	public List viewstaffFeedback(FeedbackVO feedbackVO);

	public List TotalFeedback(FeedbackVO feedbackVO);
	
	public List userTotalFeedback(FeedbackVO feedbackVO);
}
