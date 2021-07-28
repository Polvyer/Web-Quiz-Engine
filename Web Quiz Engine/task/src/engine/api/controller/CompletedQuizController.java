package engine.api.controller;

import engine.api.entity.CompletedQuiz;
import engine.api.service.CompletedQuizService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api")
@Api(tags = "completed quizzes")
public class CompletedQuizController {

    private final CompletedQuizService completedQuizService;

    @Autowired
    public CompletedQuizController(CompletedQuizService completedQuizService) {
        this.completedQuizService = completedQuizService;
    }

    @GetMapping(value = "/quizzes/completed")
    public Page<CompletedQuiz> getAllCompletedQuizzes(@RequestParam(defaultValue = "0") Integer page) {
        return completedQuizService.getAllCompletedQuizzes(page);
    }
}
