package ee.mainor.game.service;


import ee.mainor.game.dto.CreateRequest;
import ee.mainor.game.dto.Response;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class GameService {


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
}
