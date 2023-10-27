package ee.mainor.game.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "game")

public class Game {

    @Id
    private Long id;

    private Long correctAnswer;

    private String name;


}
