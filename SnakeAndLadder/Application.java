package SnakeAndLadder;

public class Application {

    public static void main(String[] args) {
        Game game = new Game(6, 6, 100);

        game.createPlayer("ARANCHA");
        game.createPlayer("PANKAJ");

        game.play();
    }
}
