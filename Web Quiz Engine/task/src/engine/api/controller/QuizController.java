package engine.api.controller;

import engine.api.dto.QuizAnswer;
import engine.api.dto.QuizAnswerResponse;
import engine.api.entity.Quiz;
import engine.api.exception.QuizNotFoundException;
import engine.api.service.QuizService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(value = "/api")
@Api(tags = "quizzes")
public class QuizController {

    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping(value = "/quizzes")
    public Page<Quiz> getAllQuizzes(@RequestParam(defaultValue = "0") Integer page) {
        return quizService.getAllQuizzes(page);
    }

    @PostMapping(value = "/quizzes", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Quiz createQuiz(@RequestBody @Valid Quiz quiz) {
        log.info("POST /quizzes");
        return quizService.createQuiz(quiz);
    }

    @GetMapping(value = "/quizzes/{id}")
    public Quiz getQuiz(@PathVariable int id)
            throws QuizNotFoundException {
        return quizService.getQuiz(id);
    }

    @DeleteMapping(value = "/quizzes/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteQuiz(@PathVariable int id)
            throws QuizNotFoundException, ResponseStatusException {
        quizService.deleteQuiz(id);
    }

    @PostMapping(value = "/quizzes/{id}/solve",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public QuizAnswerResponse solveQuiz(@RequestBody @Valid QuizAnswer answer,
                                        @PathVariable int id)
            throws IllegalArgumentException, QuizNotFoundException {
        return quizService.solveQuiz(id, answer);
    }
}
