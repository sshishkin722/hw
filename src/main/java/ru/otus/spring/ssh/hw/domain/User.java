package ru.otus.spring.ssh.hw.domain;

import org.springframework.context.MessageSource;

import ru.otus.spring.ssh.hw.dao.InputOutput;

public class User {
	
	private final String firstName;
	private final String lastName;
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getFullName() {
		return firstName + " " + lastName;
	}
	public User(InputOutput inputOutput, MessageSource messageSource) {
		super();
//		inputOutput.writeLine("Enter your first name: ");
		inputOutput.writeLine(messageSource.getMessage("firstname.request", null, null));
		firstName = inputOutput.readLine();
//		inputOutput.writeLine("Enter your last name: ");
		inputOutput.writeLine(messageSource.getMessage("lastname.request", null, null));
		lastName = inputOutput.readLine();
	}
}
