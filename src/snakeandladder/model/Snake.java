package snakeandladder.model;

public class Snake {
    private final int start;
    private final int end;

    public Snake(int start, int end) {
        if (start <= end) throw new IllegalArgumentException("Snake start must be greater than end");

        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}

