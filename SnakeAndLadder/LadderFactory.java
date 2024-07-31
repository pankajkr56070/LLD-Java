package SnakeAndLadder;

import java.util.Random;
import java.util.Set;

public class LadderFactory implements BoardElementFactory{

    @Override
    public BoardElement createElement(Board board, Set<String> snakeLadderSet) {
        while (true) {
            int ladderStart = new Random().nextInt(board.getSize()) + 1;
            int ladderEnd = new Random().nextInt(board.getSize()) + 1;
            if (ladderEnd <= ladderStart) {
                continue;
            }
            String startEndPair = String.valueOf(ladderStart) + "#" + String.valueOf(ladderEnd);
            if (!snakeLadderSet.contains(startEndPair)) {
                snakeLadderSet.add(startEndPair);
                Ladder ladder = new Ladder(ladderStart, ladderEnd);
                return ladder;
            }
        }

    }

    @Override
    public FactoryType getFactoryType() {
        return FactoryType.LADDER;
    }
}
