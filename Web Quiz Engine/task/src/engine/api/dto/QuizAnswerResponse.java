package engine.api.dto;

import lombok.Data;

@Data
public class QuizAnswerResponse {

    private static final String CORRECT_RESPONSE = "Congratulations, you're right!";
    private static final String INCORRECT_RESPONSE = "Wrong answer! Please, try again.";

    private final boolean success;
    private final String feedback;

    public QuizAnswerResponse(boolean isCorrectAnswer) {
        this.success = isCorrectAnswer;
        this.feedback = isCorrectAnswer
                ? CORRECT_RESPONSE
                : INCORRECT_RESPONSE;
    }
}
