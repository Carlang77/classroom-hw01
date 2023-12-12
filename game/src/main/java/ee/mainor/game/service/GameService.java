package ee.mainor.game.service;

import ee.mainor.game.dto.CreateRequest;
import ee.mainor.game.dto.GameDto;
import ee.mainor.game.dto.Response;
import ee.mainor.game.model.Game;
import ee.mainor.game.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    public GameDto createGame(CreateRequest gameCreateRequest) {
        // Validate the request
        if (gameCreateRequest == null || gameCreateRequest.getCorrectAnswer() == null || gameCreateRequest.getName() == null) {
            throw new IllegalArgumentException("CreateRequest and its required fields cannot be null");
        }

        // Create a new game instance
        Game game = new Game();
        game.setCorrectAnswer(Long.valueOf(gameCreateRequest.getCorrectAnswer()));
        game.setName(gameCreateRequest.getName());

        // Persist the game in the repository
        Game savedGame = gameRepository.save(game);

        // Return a DTO with the saved game's details
        return new GameDto()
                .setId(savedGame.getId())
                .setName(savedGame.getName());
    }

    public Response guessNumber(Long gameId, Integer guessableNumber) {
        Game game = gameRepository.findById(gameId).orElse(null);
        Response gameResponse = new Response();

        if (game != null && guessableNumber.equals(game.getCorrectAnswer())) {
            gameResponse.setText("You win");
        } else {
            gameResponse.setText("You lose");
        }

        return gameResponse;
    }

    public List<GameDto> getAll() {
        Iterable<Game> gamesIterable = gameRepository.findAll();
        List<Game> gameList = new ArrayList<>();
        gamesIterable.forEach(gameList::add);

        return gameList.stream()
                .map(game -> new GameDto().setId(game.getId()).setName(game.getName()))
                .collect(Collectors.toList());
    }

}
