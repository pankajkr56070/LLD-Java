package SnakeAndLadder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

public class SnakeAndLadderService {
    // Game elements
    private int numberOfSnakes;
    private int numberOfLadders;
    private List<Snake> snakes;
    private List<Ladder> ladders;

    // players : currently two player game
    private Queue<Player> players;

    private Board board;

    private Dice dice;

    public SnakeAndLadderService(int numberOfLadders, int numberOfSnakes, int boardSize) {
        this.numberOfLadders = numberOfLadders;
        this.numberOfSnakes = numberOfSnakes;
        this.snakes = new ArrayList<>(numberOfSnakes);
        this.ladders = new ArrayList<>(numberOfLadders);
        this.players = new ArrayDeque<>();
        this.board = new Board(boardSize);
        this.dice = new Dice(1);
        initBoard();
    }

    private void initBoard() {
        Set<String> snakeLadderset = new HashSet<>();
        for (int i = 0; i < numberOfSnakes; i++) {
            while (true) {
                int snakeStart = new Random().nextInt(board.getSize()) + 1;
                int snakeEnd = new Random().nextInt(board.getSize()) + 1;
                if (snakeEnd >= snakeStart) {
                    continue;
                }
                String startEndPair = String.valueOf(snakeStart) + "#" + String.valueOf(snakeEnd);
                if (!snakeLadderset.contains(startEndPair)) {
                    snakeLadderset.add(startEndPair);
                    snakes.add(new Snake(snakeStart, snakeEnd));
                    break;
                }
            }
        }

        for (int i = 0; i < numberOfLadders; i++) {
            while (true) {
                int ladderStart = new Random().nextInt(board.getSize()) + 1;
                int ladderEnd = new Random().nextInt(board.getSize()) + 1;
                if (ladderEnd <= ladderStart) {
                    continue;
                }
                String startEndPair = String.valueOf(ladderStart) + "#" + String.valueOf(ladderEnd);
                if (!snakeLadderset.contains(startEndPair)) {
                    snakeLadderset.add(startEndPair);
                    ladders.add(new Ladder(ladderStart, ladderEnd));
                    break;
                }
            }
        }

        System.out.println("Snakes are present at ");
        for (Snake snake : snakes) {
            System.out.println(snake.getHead() + "----------->" + snake.getTail());
        }

        System.out.println("Ladders are present at ");
        for (Ladder ladder : ladders) {
            System.out.println(ladder.getStart() + "----------->" + ladder.getEnd());
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
                    System.out.println("Setting " + player.getName() + "'s new position to " + player.getCurrentPosition());
                    players.offer(player);
                }
            }

        }
    }

    private int getNextPosition(int newPosition) {

        for (Snake snake : snakes) {
            if (snake.getHead() == newPosition) {
                System.out.println("Snake bit");
                return snake.getTail();
            }
        }

        for (Ladder ladder : ladders) {
            if (ladder.getStart() == newPosition) {
                System.out.println("Climbed ladder");
                return ladder.getEnd();
            }
        }

        return newPosition;

    }
}
