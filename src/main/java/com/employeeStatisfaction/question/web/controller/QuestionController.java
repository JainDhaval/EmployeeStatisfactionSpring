package com.employeeStatisfaction.question.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeeStatisfaction.question.web.entity.FeedbackEntity;
import com.employeeStatisfaction.question.web.entity.QuestionEntity;
import com.employeeStatisfaction.question.web.model.FeedbackRequest;
import com.employeeStatisfaction.question.web.service.EmployeeStatisfactionService;

@RestController
@RequestMapping("/api/v1/employee/statisfaction")
@CrossOrigin("*")
public class QuestionController {
	
	@Autowired
	EmployeeStatisfactionService employeeStatisfactionService;

	@GetMapping("/fetch/question")
	public ResponseEntity<?> getQuestionList(){
		return new ResponseEntity<List<QuestionEntity>>(employeeStatisfactionService.getAllQuestions(), HttpStatus.OK);
	}
	
	@PostMapping("/save/answers")
	public ResponseEntity<?> saveAnswers(@RequestBody FeedbackRequest feebackRequestModels){
		System.out.println(feebackRequestModels);
		FeedbackEntity result = employeeStatisfactionService.SaveAllAnswers(feebackRequestModels);
		return new ResponseEntity<FeedbackEntity>(result, HttpStatus.OK);
	}
}
