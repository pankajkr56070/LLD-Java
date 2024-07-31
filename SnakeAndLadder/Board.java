package SnakeAndLadder;

public class Board {
    private static Board instance;
    private final int size;

    public Board(int size) {
        this.size = size;

    }

    public static synchronized Board getInstance(int size) {
        if(instance == null) {
            instance = new Board(size);
        }
        return instance;
    }

    public int getSize() {
        return size;
    }
}
