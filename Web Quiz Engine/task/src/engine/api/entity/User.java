package engine.api.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Email
    @Pattern(regexp = "\\w*@\\w*[.]\\w*", message = "Email must have a valid format")
    @NotBlank(message = "Email is required")
    @Column(unique = true)
    private String email;

    @Size(min = 5, message = "Password must have at least 5 characters")
    @NotEmpty(message = "Password is required")
    private String password;
}
