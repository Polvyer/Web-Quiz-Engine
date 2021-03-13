package engine.quiz;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.Map;

public class Quiz {

    private int id;
    @NotBlank(message = "Title not found")
    private String title;
    @NotBlank(message = "Text not found")
    private String text;
    @NotNull(message = "Options should contain at least 2 items")
    @Size(min = 2, message = "Options should contain at least 2 items")
    private String[] options;
    private int[] answer;

    public Quiz() {

    }

    public Quiz(String title, String text, String[] options, int[] answer) {
        this.title = title;
        this.text = text;
        this.options = options;
        this.answer = answer;
    }

    private Map<Integer, Integer> getAnswerInMap() {
        Map<Integer, Integer> map = new HashMap<>();

        for (int elem : this.answer) {
            map.put(elem, 1);
        }

        return map;
    }

    private boolean hasCorrectAnswer(Map<Integer, Integer> map, int[] answer) {
        for (int elem : answer) {
            if (!map.containsKey(elem)) {
                return false;
            }
            map.remove(elem);
        }

        if (map.isEmpty()) {
            return true;
        }

        return false;
    }

    private int answerSize() {
        return this.answer == null ? 0 : this.answer.length;
    }

    public boolean isCorrectAnswer(int[] answer) {
        if (this.answer == null) {
            return (answer == null || answer.length == 0);
        }

        if (answer == null) {
            return (answerSize() == 0);
        }

        if (this.answer.length != answer.length) {
            return false;
        }

        return this.hasCorrectAnswer(this.getAnswerInMap(), answer);
    }

    public int getId () {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public void setAnswer(int[] answer) {
        this.answer = answer;
    }
}
