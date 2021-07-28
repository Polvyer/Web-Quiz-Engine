package engine.api.service.impl;

import engine.api.dto.QuizAnswer;
import engine.api.dto.QuizAnswerResponse;
import engine.api.entity.Quiz;
import engine.api.exception.QuizNotFoundException;
import engine.api.repository.QuizRepository;
import engine.api.entity.User;
import engine.api.service.CompletedQuizService;
import engine.api.service.QuizService;
import engine.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static engine.api.util.EngineConstants.PAGE_SIZE;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;
    private final UserService userService;
    private final CompletedQuizService completedQuizService;

    @Autowired
    public QuizServiceImpl(QuizRepository quizRepository,
                           UserService userService,
                           CompletedQuizService completedQuizService) {
        this.quizRepository = quizRepository;
        this.userService = userService;
        this.completedQuizService = completedQuizService;
    }

    @Override
    public Quiz createQuiz(Quiz quiz) {
        User user = userService.getUserFromPrincipal();
        quiz.setUser(user);
        return quizRepository.save(quiz);
    }

    @Override
    public Quiz getQuiz(int id) throws QuizNotFoundException {
        Optional<Quiz> quizFound = Optional
                .ofNullable(findQuizById(id));

        if (!quizFound.isPresent()) {
            throw new QuizNotFoundException();
        }

        return quizFound.get();
    }

    @Override
    public Page<Quiz> getAllQuizzes(Integer page) {
        Pageable paging = PageRequest.of(page, PAGE_SIZE);
        Page<Quiz> pagedResult = quizRepository.findAll(paging);
        return pagedResult;
    }

    @Override
    public QuizAnswerResponse solveQuiz(int id, QuizAnswer answer)
            throws QuizNotFoundException {
        Quiz quiz = getQuiz(id);
        QuizAnswer correctAnswer = QuizAnswer.builder()
                .answer(quiz.getAnswer())
                .build();

        boolean isCorrectAnswer = answer.equals(correctAnswer);

        if (isCorrectAnswer) {
            completedQuizService.saveCompletedQuiz(id);
        }

        return new QuizAnswerResponse(isCorrectAnswer);
    }

    @Override
    public void deleteQuiz(int id)
            throws QuizNotFoundException, ResponseStatusException {
        Quiz quiz = getQuiz(id);
        User author = quiz.getUser();

        // Check if the specified user is not the author of this quiz
        User user = userService.getUserFromPrincipal();
        if (!user.equals(author)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN,
                    "User is not the author of this quiz");
        }

        quizRepository.delete(quiz);
    }

    private Quiz findQuizById(int id) {
        return quizRepository.findById(id).orElse(null);
    }
}
