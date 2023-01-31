package com.employeeStatisfaction.question.web.model;

import lombok.Data;

@Data
public class FeedbackRequest {
	private String name;
	private String email;
	private String department;
	private int question1;
	private String question2;
	private String question3;
	private String question4;
	private int question5;
}
