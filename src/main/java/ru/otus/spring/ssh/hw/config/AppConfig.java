package ru.otus.spring.ssh.hw.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import ru.otus.spring.ssh.hw.dao.InputOutput;
import ru.otus.spring.ssh.hw.dao.InputOutputConsoleImpl;
import ru.otus.spring.ssh.hw.dao.QuestionDao;
import ru.otus.spring.ssh.hw.dao.QuestionDaoImpl;
import ru.otus.spring.ssh.hw.domain.User;
import ru.otus.spring.ssh.hw.service.QuestionService;
import ru.otus.spring.ssh.hw.service.RandomQuestionService;
import ru.otus.spring.ssh.hw.service.TestService;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
		ms.setBasename("/i18n/bundle");
		ms.setDefaultEncoding("UTF-8");
		
		return ms;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean
	InputOutput inputOutput() {
		return new InputOutputConsoleImpl();
	}
	
	@Bean
	@Autowired
	User user(InputOutput inputOutput, MessageSource messageSource) {
		return new User(inputOutput, messageSource);
	}
	
	@Bean
	QuestionDao questionDao() {
		return new QuestionDaoImpl();
	}
	
	@Bean
	@Autowired
	QuestionService questionService(QuestionDao questionDao) {
		return new RandomQuestionService(questionDao);
	}
	
	@Bean
	@Autowired
	TestService testService(InputOutput inputOutput, User user, QuestionService questionService) {
		return new TestService(inputOutput, user, questionService);
	}
}
