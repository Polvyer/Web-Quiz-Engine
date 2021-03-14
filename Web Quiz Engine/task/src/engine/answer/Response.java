package engine.answer;

public class Response {

    private boolean success;
    private String feedback;

    public Response(boolean isCorrect) {
        this.success = isCorrect;
        this.feedback = isCorrect ? "Congratulations, you're right!"
                : "Wrong answer! Please, try again.";
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
