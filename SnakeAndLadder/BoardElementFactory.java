package SnakeAndLadder;

import java.util.Set;

public interface BoardElementFactory {

    BoardElement createElement(Board board, Set<String> exisitngElements);
    FactoryType getFactoryType(); // New method to return factory type

}
