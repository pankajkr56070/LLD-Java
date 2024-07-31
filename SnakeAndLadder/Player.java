package SnakeAndLadder;

public class Player {
    private final String name;
    private int currentPosition;

    public String getName() {
        return name;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public Player(String name) {
        this.name = name;
        this.currentPosition = 0;
    }
}
