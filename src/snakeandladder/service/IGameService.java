package snakeandladder.service;

import snakeandladder.model.player.Player;

public interface IGameService {

    void addPlayer(Player player);

    void startGame();
}
