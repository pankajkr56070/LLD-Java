package SnakeAndLadder;

public class GameBuilder {
    private int numberOfSnakes;
    private int numberOfLadders;
    private int boardSize;

    public GameBuilder setNumberOfSnakes(int numberOfSnakes) {
        this.numberOfSnakes = numberOfSnakes;
        return this;
    }

    public GameBuilder setNumberOfLadders(int numberOfLadders) {
        this.numberOfLadders = numberOfLadders;
        return this;
    }

    public GameBuilder setBoardSize(int boardSize) {
        this.boardSize = boardSize;
        return this;
    }

    public Game build() {
        return new Game(numberOfLadders, numberOfSnakes, boardSize);
    }

}
