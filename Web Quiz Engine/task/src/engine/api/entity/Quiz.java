package engine.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Text is required")
    private String text;

    @NotNull(message = "Options are required")
    @Size(min = 2, message = "Options must have at least 2 items")
    @ElementCollection
    private List<String> options;

    @ElementCollection
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Integer> answer;

    @ManyToOne
    @JoinColumn(name = "UserID")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user;

    public int[] getAnswer() {
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
