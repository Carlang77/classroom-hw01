package ee.mainor.game.dto;

import lombok.Data;

@Data
public class CreateRequest {
    private Integer correctAnswer;
    private String name;  // Added field for the name

    // The @Data annotation will automatically generate getters and setters,
    // as well as equals(), hashCode(), and toString() methods.
}
