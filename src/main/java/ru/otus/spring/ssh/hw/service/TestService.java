package ru.otus.spring.ssh.hw.service;

import ru.otus.spring.ssh.hw.dao.InputOutput;
import ru.otus.spring.ssh.hw.domain.Question;
import ru.otus.spring.ssh.hw.domain.User;

public class TestService {
	private static final int REQUESTS_COUNT = 5;
	
	private final InputOutput inputOutput;
	private final User user;
	private final QuestionService questionService;
	public TestService(InputOutput inputOutput, User user, QuestionService questionService) {
		super();
		this.inputOutput = inputOutput;
		this.user = user;
		this.questionService = questionService;
	};
	public double performTest() {
		int successesCoint = 0;

		for (int i = 0; i < REQUESTS_COUNT; i++) {
			Question question = questionService.getQuestion();
			inputOutput.writeLine(question.getRequest());
			String answer = inputOutput.readLine();
			if (question.checkAnswer(answer)) {
				successesCoint++;
			}
		}
		
		inputOutput.writeLine(String.format("%s, your results are: %d/%d", user.getFullName(), successesCoint, REQUESTS_COUNT));
		
		return successesCoint/(double)REQUESTS_COUNT;
	}
}
