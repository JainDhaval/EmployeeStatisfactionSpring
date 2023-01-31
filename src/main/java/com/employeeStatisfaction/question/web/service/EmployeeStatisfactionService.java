package com.employeeStatisfaction.question.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employeeStatisfaction.question.web.entity.FeedbackEntity;
import com.employeeStatisfaction.question.web.entity.QuestionEntity;
import com.employeeStatisfaction.question.web.model.FeedbackRequest;

@Service
public interface EmployeeStatisfactionService {
	public List<QuestionEntity> getAllQuestions();
	public FeedbackEntity SaveAllAnswers(FeedbackRequest feedback);
}
