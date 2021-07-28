package engine.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import engine.api.util.CompletedQuizId;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@IdClass(CompletedQuizId.class)
public class CompletedQuiz {

    @Id
    private int id;

    @Id
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String email;

    @Id
    private LocalDateTime completedAt;
}
