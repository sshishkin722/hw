package ru.otus.spring.ssh.hw;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import ru.otus.spring.ssh.hw.service.TestService;

@ComponentScan//(basePackages = {"ru.otus.spring.ssh.hw.config"})
public class Main {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
//		InputOutput inputOutput = new InputOutputConsoleImpl();
//		User user = new User(inputOutput);
//		QuestionService questionService = new RandomQuestionService(new QuestionDaoImpl());
//		TestService testService = new TestService(inputOutput, user, questionService);
//		testService.performTest();
		
//    	@SuppressWarnings("resource")
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
		//context.refresh(); // recreate all beans on refreshing
    	
    	@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
		
		TestService testService = context.getBean(TestService.class);
		testService.performTest();
	}

}
