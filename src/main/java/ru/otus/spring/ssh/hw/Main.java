package ru.otus.spring.ssh.hw;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.otus.spring.ssh.hw.service.TestService;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, IOException {
//		InputOutput inputOutput = new InputOutputConsoleImpl();
//		User user = new User(inputOutput);
//		QuestionService questionService = new RandomQuestionService(new QuestionDaoImpl());
//		TestService testService = new TestService(inputOutput, user, questionService);
//		testService.performTest();
		
    	@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
		//context.refresh(); // recreate all beans on refreshing
		
		TestService testService = context.getBean(TestService.class);
		testService.performTest();
	}

}
