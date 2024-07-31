package SnakeAndLadder;

public class Application {

    public static void main(String[] args) {
        //builder pattern
        Game game = new GameBuilder()
            .setNumberOfLadders(6)
            .setNumberOfSnakes(6)
            .setBoardSize(100)
            .build();

        game.createPlayer("ARANCHA");
        game.createPlayer("PANKAJ");

        game.play();
    }
}
