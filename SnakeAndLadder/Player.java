package SnakeAndLadder;

public class Player {
    private String name;

    public String getName() {
        return name;
    }

    private int currentPosition;

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public Player(String name) {
        this.name = name;
        this.currentPosition = 1;
    }
}
