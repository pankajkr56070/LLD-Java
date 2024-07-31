package SnakeAndLadder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Game {
    // Game elements
    private final List<BoardElement> boardElements;

    // players : currently two player game
    private final Queue<Player> players;

    private final Board board;

    private final Dice dice;

    public Game(int numberOfLadders, int numberOfSnakes, int boardSize) {
        this.boardElements = new ArrayList<>();
        this.players = new ArrayDeque<>();
        this.board = Board.getInstance(boardSize); // Singleton pattern
        this.dice = new StandardDice(); // Strategy pattern

        initBoard(numberOfSnakes, numberOfLadders);
    }

    private void initBoard(int numberOfSnakes, int numberOfLadders) {
        Set<String> snakeLadderSet = new HashSet<>();
        List<BoardElementFactory> elementFactories = Arrays.asList(new SnakeFactory(), new LadderFactory());

        for (BoardElementFactory factory : elementFactories) {
            switch (factory.getFactoryType()) {
                case SNAKE:
                    createElements(numberOfSnakes, factory, snakeLadderSet);
                    break;
                case LADDER:
                    createElements(numberOfLadders, factory, snakeLadderSet);
                    break;
                default:
                    break;
            }
        }

        displayElements();

    }

    private void createElements(int numberOfElements, BoardElementFactory factory, Set<String> snakeLadderSet) {
        for (int i = 0; i < numberOfElements; i++) {
            boardElements.add(factory.createElement(board, snakeLadderSet));
        }
    }

    private void displayElements() {

        for (BoardElement element : boardElements) {
            switch (element.getType()) {
                case SNAKE:
                    System.out.println("Snake: " + element.getStart() + " -----------> " + element.getEnd());
                    break;
                case LADDER:
                    System.out.println("Ladder: " + element.getStart() + " -----------> " + element.getEnd());
                    break;
                default:
                    break;
            }
        }
    }

    public void createPlayer(String name) {
        Player player = new Player(name);
        players.add(player);
        System.out.println("Player added " + name + " at positon : " + player.getCurrentPosition());
    }

    public void play() {
        int cnt = 0;
        while (true) {
            Player player = players.poll();
            int value = dice.roll();
            cnt++;

            int newPosition = player.getCurrentPosition() + value;
            // if the new position is out of the board size
            if (newPosition > board.getSize()) {
                System.out.println(
                        player.getName() + " remain at this position " + player.getCurrentPosition());
                players.offer(player);
            } else {
                player.setCurrentPosition(getNextPosition(newPosition));
                if (player.getCurrentPosition() == board.getSize()) {
                    System.out.println("Player " + player.getName() + " Won.");
                    System.out.println("Total dice rolls : " + cnt);
                    break;
                } else {
                    System.out.println(
                            "Setting " + player.getName() + "'s new position to " + player.getCurrentPosition());
                    players.offer(player);
                }
            }

        }
    }

    private int getNextPosition(int newPosition) {

        for (BoardElement element : boardElements) {
            if (element.getStart() == newPosition) {
                switch (element.getType()) {
                    case SNAKE:
                        System.out.println("Snake bit");
                    case LADDER:
                        System.out.println("Climbed ladder");
                }
                return element.getEnd();
            }
        }

        return newPosition;

    }
}
