package ee.mainor.game.web;

import ee.mainor.game.dto.CreateRequest;
import ee.mainor.game.dto.GameDto;
import ee.mainor.game.dto.Response;
import ee.mainor.game.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("game")
@RequiredArgsConstructor
public class GameControl {

    private final GameService gameService;

    @PostMapping
    public GameDto createGame(@RequestBody CreateRequest gameCreateRequest) {
        return gameService.createGame(gameCreateRequest);
    }

    @GetMapping("{gameId}/guess/{number}")
    public Response guess(@PathVariable Long gameId, @PathVariable Integer number) {
        return gameService.guessNumber(gameId, number);
    }

    @GetMapping
    public List<GameDto> getAll() {
        return gameService.getAll();
    }
}
