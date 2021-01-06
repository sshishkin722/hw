package ru.otus.spring.ssh.hw.domain;

public class Question {
	private final String request;
	private final String answer;
	public Question(String request, String answer) {
		super();
		this.request = request;
		this.answer = answer;
	}
	public String getRequest() {
		return request;
	}
	public boolean checkAnswer(String answer) {
		return this.answer.equals(answer);
	}
}
