package engine.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class QuizService {

    private List<Quiz> quizzes;

    @Autowired
    private QuizRepository quizRepository;

    public QuizService() {
        this.quizzes = new ArrayList<>();
    }

    public Quiz addQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public Quiz findQuizById(int id) {
        return quizRepository.findById(id).orElse(null);
    }

    public List<Quiz> getAllQuizzes() {
        List<Quiz> quizzes = new ArrayList<>();
        quizRepository.findAll()
                .forEach(quiz -> quizzes.add(quiz));
        return quizzes;
    }

    public boolean solveQuiz(int id, int[] answer) {
        return quizRepository.findById(id).get()
                .isCorrectAnswer(answer);
    }
}
