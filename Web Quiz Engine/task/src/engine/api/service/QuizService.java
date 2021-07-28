package engine.api.service;

import engine.api.dto.QuizAnswer;
import engine.api.dto.QuizAnswerResponse;
import engine.api.entity.Quiz;
import org.springframework.data.domain.Page;

public interface QuizService {

    Quiz createQuiz(Quiz quiz);

    Quiz getQuiz(int id);

    Page<Quiz> getAllQuizzes(Integer page);

    QuizAnswerResponse solveQuiz(int id, QuizAnswer answer);

    void deleteQuiz(int id);
}
