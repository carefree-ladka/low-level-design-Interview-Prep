package snakeandladder.model.player;

public abstract class Player {
    protected String name;
    protected int currentPosition;

    public Player(String name) {
        this.name = name;
        this.currentPosition = 0;
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void move(int steps) {
        currentPosition += steps;
    }

    public void setPosition(int position) {
        this.currentPosition = position;
    }
}
