package com.employeeStatisfaction.question.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeStatisfaction.question.web.entity.FeedbackEntity;
import com.employeeStatisfaction.question.web.entity.QuestionEntity;
import com.employeeStatisfaction.question.web.model.FeedbackRequest;
import com.employeeStatisfaction.question.web.repository.FeedbackRepository;
import com.employeeStatisfaction.question.web.repository.QuestionRepository;

@Service
public class EmplyeeStatisfactionServiceImpl implements EmployeeStatisfactionService {

	@Autowired
	QuestionRepository questionRepository;
	
	@Autowired
	FeedbackRepository feedbackRepository;

	@Override
	public List<QuestionEntity> getAllQuestions() {
		List<QuestionEntity> questionList = questionRepository.findAll();
		return questionList;
	}

	@Override
	public FeedbackEntity SaveAllAnswers(FeedbackRequest feedback) {
		FeedbackEntity feedbackEntity = new FeedbackEntity();
		feedbackEntity.setName(feedback.getName());
		feedbackEntity.setDepartment(feedback.getDepartment());
		feedbackEntity.setEmail(feedback.getEmail());
		feedbackEntity.setQuestion1(feedback.getQuestion1());
		feedbackEntity.setQuestion2(feedback.getQuestion2());
		feedbackEntity.setQuestion3(feedback.getQuestion3());
		feedbackEntity.setQuestion4(feedback.getQuestion4());
		feedbackEntity.setQuestion5(feedback.getQuestion5());
		int result = feedback.getQuestion1() + feedback.getQuestion5();
		if(feedback.getQuestion2().contains("YES")) {
			result += 100;
		}else if (feedback.getQuestion2().contains("neutral")) {
			result += 50;
		}
		if(feedback.getQuestion3().contains("transparency")) {
			result += 100;
		}else if (feedback.getQuestion3().contains("neutral")) {
			result += 50;
		}
		if(feedback.getQuestion4().toLowerCase().contains("yes")) {
			result += 100;
		}else if (feedback.getQuestion4().toLowerCase().contains("no")) {
			result += 0;
		}
		if(result/5 >= 90) {
			feedbackEntity.setResult("Happiest");
		}
		else if (result/5 >= 75) {
			feedbackEntity.setResult("Happy");
		}
		else if (result/5 >= 50) {
			feedbackEntity.setResult("Neutral");
		}
		else if (result/5 >= 25) {
			feedbackEntity.setResult("Sad");
		}
		else {
			feedbackEntity.setResult("Saddest");
		}
		feedbackRepository.save(feedbackEntity);
		return feedbackEntity;
	}

}
