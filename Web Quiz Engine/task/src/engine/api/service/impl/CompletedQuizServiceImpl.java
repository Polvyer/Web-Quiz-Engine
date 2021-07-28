package engine.api.service.impl;

import engine.api.entity.CompletedQuiz;
import engine.api.repository.CompletedQuizRepository;
import engine.api.service.CompletedQuizService;
import engine.api.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static engine.api.util.EngineConstants.PAGE_SIZE;
import static engine.api.util.EngineConstants.PAGE_SORTING;

@Slf4j
@Service
public class CompletedQuizServiceImpl implements CompletedQuizService {

    private final CompletedQuizRepository completedQuizRepository;
    private final UserService userService;

    @Autowired
    public CompletedQuizServiceImpl(CompletedQuizRepository completedQuizRepository,
                                    UserService userService) {
        this.completedQuizRepository = completedQuizRepository;
        this.userService = userService;
    }

    @Override
    public Page<CompletedQuiz> getAllCompletedQuizzes(Integer page) {
        String email = userService.getEmailFromPrincipal();
        Pageable paging = PageRequest.of(page, PAGE_SIZE, Sort.by(PAGE_SORTING).descending());
        Page<CompletedQuiz> pagedResult =
                completedQuizRepository.findAllByEmail(email, paging);
        return pagedResult;
    }

    @Override
    public void saveCompletedQuiz(int id) {
        String email = userService.getEmailFromPrincipal();
        CompletedQuiz completedQuiz = new CompletedQuiz();
        completedQuiz.setId(id);
        completedQuiz.setEmail(email);
        completedQuiz.setCompletedAt(LocalDateTime.now());
        completedQuizRepository.save(completedQuiz);
    }
}
