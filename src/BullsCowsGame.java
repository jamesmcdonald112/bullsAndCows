import game.Game;

/**
 * The BullsCowsGame class is the entry point for the Bulls and Cows game.
 * It initialises and starts the game.
 */
public class BullsCowsGame {

    /**
     * The main method is the entry point of the application.
     * It creates an instance of the Game class and starts the game.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
