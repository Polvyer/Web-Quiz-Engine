package engine.quiz;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class QuizService {

    private static int idCounter;
    private List<Quiz> quizzes;

    public QuizService() {
        this.quizzes = new ArrayList<>();
        this.idCounter = 0;
    }

    public void incrementIdCounter() {
        this.idCounter++;
    }

    public Quiz addQuiz(Quiz quiz) {
        this.quizzes.add(quiz);
        this.incrementIdCounter();
        quiz.setId(idCounter);
        return quiz;
    }

    public Quiz findQuizById(int id) {
        Iterator<Quiz> iterator = this.quizzes.iterator();

        while (iterator.hasNext()) {
            Quiz quiz = iterator.next();
            if (quiz.getId() == id) {
                return quiz;
            }
        }

        return null;
    }

    public List<Quiz> getAllQuizzes() {
        return this.quizzes;
    }

    public boolean solveQuiz(int id, int[] answer) {
        Iterator<Quiz> iterator = this.quizzes.iterator();

        while (iterator.hasNext()) {
            Quiz quiz = iterator.next();
            if (quiz.getId() == id) {
                return quiz.isCorrectAnswer(answer);
            }
        }

        return false;
    }
}
