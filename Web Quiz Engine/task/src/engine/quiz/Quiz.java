package engine.quiz;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int id;

    @NotBlank(message = "Title not found")
    private String title;

    @NotBlank(message = "Text not found")
    private String text;

    @NotNull(message = "Options should contain at least 2 items")
    @Size(min = 2, message = "Options should contain at least 2 items")
    @ElementCollection
    private List<String> options;

    @ElementCollection
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Integer> answer;

    public Quiz() {
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
        return this.answer == null ? 0 : this.answer.size();
    }

    public boolean isCorrectAnswer(int[] answer) {
        if (this.answer == null) {
            return (answer == null || answer.length == 0);
        }

        if (answer == null) {
            return (answerSize() == 0);
        }

        if (this.answer.size() != answer.length) {
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

    public List<String> getOptions() {
        return options;
    }

    public List<Integer> getAnswer() { return answer; }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }

    public String toString() {
        return "Id: " + this.id;
    }
}
