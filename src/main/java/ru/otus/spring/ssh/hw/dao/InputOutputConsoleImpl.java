package ru.otus.spring.ssh.hw.dao;

import java.util.Scanner;

public class InputOutputConsoleImpl implements InputOutput {
	private final Scanner scanner;

	public InputOutputConsoleImpl() {
		super();
		this.scanner = new Scanner(System.in);
	}

	@Override
	public String readLine() {
		return scanner.nextLine();
	}

	@Override
	public void writeLine(String line) {
		System.out.println(line);
	}

}
