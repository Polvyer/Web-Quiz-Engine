package engine.answer;

public class Response {

    private boolean success;
    private String feedback;

    public Response(boolean isCorrect) {
        if (isCorrect) {
            this.success = true;
            this.feedback = "Congratulations, you're right!";
        } else {
            this.success = false;
            this.feedback = "Wrong answer! Please, try again.";
        }
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
