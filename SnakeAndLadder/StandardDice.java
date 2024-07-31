package SnakeAndLadder;

import java.util.Random;

public class StandardDice implements Dice {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 6;

    @Override
    public int roll() {
        Random rand = new Random();
        return rand.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
    }
}