package SnakeAndLadder;

import java.util.Random;

public class Dice {

    private int minValue;
    private int maxValue;
    private int currentValue;

    public Dice(int currentValue) {
        this.minValue = 1;
        this.maxValue = 6;
        this.currentValue = currentValue;
    }

    public int roll() {
        Random rand = new Random();

        return rand.nextInt(maxValue - minValue + 1) + minValue;
    }
}
