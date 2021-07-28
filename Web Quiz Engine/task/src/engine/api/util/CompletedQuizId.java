package engine.api.util;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class CompletedQuizId implements Serializable {

    private int id;

    private String email;

    private LocalDateTime completedAt;

    public CompletedQuizId(int id, String email, LocalDateTime completedAt) {
        this.id = id;
        this.email = email;
        this.completedAt = completedAt;
    }
}
