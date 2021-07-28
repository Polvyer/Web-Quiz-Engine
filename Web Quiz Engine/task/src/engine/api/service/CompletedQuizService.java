package engine.api.service;

import engine.api.entity.CompletedQuiz;
import org.springframework.data.domain.Page;

public interface CompletedQuizService {

    Page<CompletedQuiz> getAllCompletedQuizzes(Integer page);

    void saveCompletedQuiz(int id);
}
