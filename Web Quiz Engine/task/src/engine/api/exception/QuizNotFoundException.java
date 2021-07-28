package engine.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class QuizNotFoundException extends RuntimeException {

    private static final String MESSAGE = "Quiz not found";

    public QuizNotFoundException() {
        super(MESSAGE);
    }
}
