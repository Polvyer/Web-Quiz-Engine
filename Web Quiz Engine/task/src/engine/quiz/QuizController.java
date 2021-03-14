package engine.quiz;

import engine.answer.Response;
import engine.answer.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
public class QuizController {

    private QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @RequestMapping(method=RequestMethod.POST, value="/api/quizzes", consumes=MediaType.APPLICATION_JSON_VALUE)
    public Quiz createQuiz(@RequestBody @Valid Quiz quiz) {
        return this.quizService.addQuiz(quiz);
    }

    @RequestMapping("/api/quizzes/{id}")
    public Quiz getQuiz(@PathVariable int id) throws ResponseStatusException {
        Quiz quizFound = this.quizService.findQuizById(id);

        if (quizFound == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Quiz not found");
        }

        return quizFound;
    }

    @RequestMapping("/api/quizzes")
    public List<Quiz> getAllQuizzes() {
        return this.quizService.getAllQuizzes();
    }

    @RequestMapping(method=RequestMethod.POST, value="/api/quizzes/{id}/solve", consumes=MediaType.APPLICATION_JSON_VALUE)
    public Response solveQuiz(@RequestBody Request request, @PathVariable int id)
            throws IllegalArgumentException, ResponseStatusException {
        if (request == null) {
            throw new IllegalArgumentException("Answer not provided");
        }

        Quiz quiz = this.quizService.findQuizById(id);

        if (quiz == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Quiz not found");
        }

        boolean isCorrect = this.quizService.solveQuiz(id, request.getAnswer());

        return new Response(isCorrect);
    }
}
