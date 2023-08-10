package ru.skypro.exam.kurs_work.service;

import org.springframework.stereotype.Service;
import ru.skypro.exam.kurs_work.exception.IncorrectQuestionsAmountException;
import ru.skypro.exam.kurs_work.model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImp implements ExaminerService {
    private final QuestionService questionService;
public ExaminerServiceImp(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount <= 0 || amount > questionService.getAll().size()) {
            throw new IncorrectQuestionsAmountException();
        }

        Set<Question> questions = new HashSet<>();

        while (questions.size() < amount) {
            questions.add(questionService.getRandomQuestion());
        }
        return questions;
    }
}
