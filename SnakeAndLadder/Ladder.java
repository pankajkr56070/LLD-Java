package SnakeAndLadder;

public class Ladder implements BoardElement {

    private final int start;
    private final int end;

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public Ladder(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public BoardElementType getType() {
        return BoardElementType.LADDER;
    }
}
