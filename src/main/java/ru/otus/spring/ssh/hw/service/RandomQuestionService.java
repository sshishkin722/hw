package ru.otus.spring.ssh.hw.service;

import ru.otus.spring.ssh.hw.dao.QuestionDao;
import ru.otus.spring.ssh.hw.domain.Question;

public class RandomQuestionService implements QuestionService {
	
	private QuestionDao questionDao;
	public RandomQuestionService(QuestionDao questionDao) {
		super();
		this.questionDao = questionDao;
	}


	@Override
	public Question getQuestion() {
		int index = (int)Math.round(Math.random()*(questionDao.getQuestionsCount()-1));
		return questionDao.findQuestionByIndex(index);
	}

}
