package snakeandladder.app;

import snakeandladder.model.Board;
import snakeandladder.model.Ladder;
import snakeandladder.model.Snake;
import snakeandladder.model.player.HumanPlayer;
import snakeandladder.service.IGameService;
import snakeandladder.service.impl.SnakeLadderGameService;
import snakeandladder.util.Dice;

public class Main {

    void main() {
        final int BOARD_SIZE = 100;
        final int DICE_SIZE = 6;

        Board board = new Board(BOARD_SIZE);

        board.addSnake(new Snake(99, 21));
        board.addSnake(new Snake(56, 12));
        board.addSnake(new Snake(75, 32));

        board.addLadder(new Ladder(2, 23));
        board.addLadder(new Ladder(8, 34));
        board.addLadder(new Ladder(20, 77));

        Dice dice = new Dice(DICE_SIZE);

        IGameService game = new SnakeLadderGameService(board, dice);

        game.addPlayer(new HumanPlayer("Pawan"));
        game.addPlayer(new HumanPlayer("Priya"));

        game.startGame();
    }
}
