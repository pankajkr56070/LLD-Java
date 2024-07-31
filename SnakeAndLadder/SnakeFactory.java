package SnakeAndLadder;

import java.util.Random;
import java.util.Set;

public class SnakeFactory implements  BoardElementFactory{

    @Override
    public  Snake createElement(Board board, Set<String> snakeLadderSet) {
        while (true) {
            int snakeStart = new Random().nextInt(board.getSize()) + 1;
            int snakeEnd = new Random().nextInt(board.getSize()) + 1;
            if (snakeEnd >= snakeStart) {
                continue;
            }
            String startEndPair = String.valueOf(snakeStart) + "#" + String.valueOf(snakeEnd);
            if (!snakeLadderSet.contains(startEndPair)) {
                snakeLadderSet.add(startEndPair);
                Snake snake = new Snake(snakeStart, snakeEnd);
                return snake;
            }
        }
    }

    @Override
    public FactoryType getFactoryType() {
        return FactoryType.SNAKE;
    }

}
