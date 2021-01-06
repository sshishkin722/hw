package ru.otus.spring.ssh.hw.dao;

import ru.otus.spring.ssh.hw.domain.Question;

public interface QuestionDao {
	Question findQuestionByIndex(int index);
	int getQuestionsCount();
}
