package ru.otus.spring.ssh.hw.dao;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import ru.otus.spring.ssh.hw.domain.Question;

public class QuestionDaoImpl implements QuestionDao {
	public static final String COMMA_DELIMITER = "\t";

	private List<Question> questions = new ArrayList<>();
	
	public QuestionDaoImpl() {
		super();
		try (	InputStream questionsStream = getClass().getResourceAsStream("/questions.csv");
				BufferedReader br = new BufferedReader(new InputStreamReader(questionsStream))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] parts = line.split(COMMA_DELIMITER);
		        questions.add(new Question(parts[0], parts[1]));
		    }
		} catch (Throwable t) {
			throw new RuntimeException(String.format("Can't create '%' instance", getClass().getCanonicalName()), t);
		}
	}

	@Override
	public Question findQuestionByIndex(int index) {
		return questions.get(index);
	}

	@Override
	public int getQuestionsCount() {
		return questions.size();
	}

}
