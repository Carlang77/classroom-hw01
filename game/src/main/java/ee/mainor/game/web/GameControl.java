package ee.mainor.game.web;



import ee.mainor.game.service.GameService;
import ee.mainor.game.dto.Response;
import ee.mainor.game.dto.CreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("game")
@RequiredArgsConstructor
public class GameControl {

    private final GameService guessingGameService;

    @PostMapping
    public Integer createGame(@RequestBody CreateRequest gameCreateRequest) {
        return guessingGameService.createGame(gameCreateRequest);
    }

    @GetMapping("{gameId}/guess/{number}")
    public Response guess(@PathVariable Integer gameId, @PathVariable Integer number) {
        return guessingGameService.guessNumber(gameId, number);
    }



}
