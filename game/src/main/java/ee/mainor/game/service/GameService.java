package ee.mainor.game.service;


import ee.mainor.game.dto.CreateRequest;
import ee.mainor.game.dto.Response;

import ee.mainor.game.model.Game;
import ee.mainor.game.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository GameRepository;


    private Map<Integer, Integer> games = new HashMap<>();
    private Random random = new Random();

    public Integer createGame(CreateRequest gameCreateRequest) {
        Integer id = random.nextInt();
        games.put(id, gameCreateRequest.getCorrectAnswer());
        return id;
    }

    public Response guessNumber(Integer gameId, Integer guessableNumber) {
        Integer correctAnswer = games.get(gameId);
        Response gameResponse = new Response();
        if (guessableNumber.equals(correctAnswer)) {
            gameResponse.setText("You win");
        } else {
            gameResponse.setText("you lose");
        }

        return gameResponse;
    }

    public Iterable<Game> getAll(){

        return GameRepository.findAll();
    }

}
