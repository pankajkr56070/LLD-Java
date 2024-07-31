package SnakeAndLadder;

public class Board {
    private int SIZE;
    private int start;
    private int end;

    public Board(int size) {
        this.SIZE = size;
        this.start = 1;
        this.end = start + size - 1;
    }

    public int getSize() {
        return SIZE;
    }
}
