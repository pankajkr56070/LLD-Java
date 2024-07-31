package SnakeAndLadder;

public class Snake implements BoardElement {
    private final int head;
    private final int tail;

    public Snake(int head, int tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public int getStart() {
        return head;
    }

    @Override
    public int getEnd() {
       return tail;
    }

    @Override
    public BoardElementType getType() {
       return BoardElementType.SNAKE;
    }
}
