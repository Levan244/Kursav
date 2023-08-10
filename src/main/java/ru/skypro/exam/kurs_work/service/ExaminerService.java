package ru.skypro.exam.kurs_work.service;

import ru.skypro.exam.kurs_work.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);

}
