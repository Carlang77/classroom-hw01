package ee.mainor.game.web;



import ee.mainor.game.model.Game;
import ee.mainor.game.service.GameService;
import ee.mainor.game.dto.Response;
import ee.mainor.game.dto.CreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("game")
@RequiredArgsConstructor
public class GameControl {

    private final GameService GameService;

    @PostMapping
    public Integer createGame(@RequestBody CreateRequest gameCreateRequest) {
        return GameService.createGame(gameCreateRequest);
    }

    @GetMapping("{gameId}/guess/{number}")
    public Response guess(@PathVariable Integer gameId, @PathVariable Integer number) {
        return GameService.guessNumber(gameId, number);
    }

    @GetMapping
    public Iterable<Game> getAll(){
        return GameService.getAll();
    }





}
