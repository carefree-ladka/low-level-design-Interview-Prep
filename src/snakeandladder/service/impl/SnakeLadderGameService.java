package snakeandladder.service.impl;

import module java.base;
import snakeandladder.model.Board;
import snakeandladder.model.Cell;
import snakeandladder.model.player.Player;
import snakeandladder.service.IGameService;
import snakeandladder.util.Dice;

public class SnakeLadderGameService implements IGameService {
    private final Board board;
    private final Dice dice;
    private final List<Player> players;
    private boolean gameOver;

    public SnakeLadderGameService(Board board, Dice dice) {
        this.board = board;
        this.dice = dice;
        this.players = new ArrayList<>();
        this.gameOver = false;
    }

    @Override
    public void addPlayer(Player player) {
        players.add(player);
    }

    @Override
    public void startGame() {
        if (players.isEmpty()) {
            IO.println("There are no players in the board.");
            return;
        }

        IO.println("Starting Snake & Ladder Game...");

        while (!gameOver) {
            for (Player player : players) {
                int roll = dice.roll();
                IO.println("[" + player.getName() + "]" + " rolled: " + roll);

                int position = player.getCurrentPosition() + roll;

                if (position <= board.getSize()) {
                    player.move(roll);

                    Cell cell = board.getCell(player.getCurrentPosition());

                    if (cell.hasSnake()) {
                        IO.println("[" + player.getName() + "]" + " bitten by a snake! Go down from " + cell.getSnake().getStart() + " to " + cell.getSnake().getEnd());
                        player.setPosition(cell.getSnake().getEnd());
                    } else if (cell.hasLadder()) {
                        IO.println("[" + player.getName() + "]" + " climbed a ladder! Go up from " + cell.getLadder().getStart() + " to " + cell.getLadder().getEnd());
                        player.setPosition(cell.getLadder().getEnd());
                    }

                    IO.println("[" + player.getName() + "]" + " is at position: " + player.getCurrentPosition());

                    if (player.getCurrentPosition() == board.getSize()) {
                        IO.println(player.getName() + " won!");
                        gameOver = true;
                        break;
                    }
                } else {
                    IO.println("[" + player.getName() + "]" + " can't move, needs exact roll to reach " + board.getSize() + ".");
                }
            }
        }
    }
}
