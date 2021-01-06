package ru.otus.spring.ssh.hw.domain;

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
	public User(InputOutput inputOutput) {
		super();
		inputOutput.writeLine("Enter your first name: ");
		firstName = inputOutput.readLine();
		inputOutput.writeLine("Enter your last name: ");
		lastName = inputOutput.readLine();
	}
}
