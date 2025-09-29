package snakeandladder.model;

import module java.base;

public class Board {
    private final int size;
    private final Map<Integer, Cell> cells;

    public Board(int size) {
        this.size = size;
        this.cells = new HashMap<>();

        for (int i = 1; i <= size; i++) {
            cells.put(i, new Cell(i));
        }
    }

    public int getSize() {
        return size;
    }

    public Cell getCell(int position) {
        return cells.get(position);
    }

    public void addSnake(Snake snake) {
        cells.get(snake.getStart()).setSnake(snake);
    }

    public void addLadder(Ladder ladder) {
        cells.get(ladder.getStart()).setLadder(ladder);
    }
}
