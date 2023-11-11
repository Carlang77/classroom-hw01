package ee.mainor.game.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class GameDto {

    private String name;
    private Long id;
}
