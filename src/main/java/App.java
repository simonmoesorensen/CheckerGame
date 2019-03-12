import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Game game = new Game();

        Scanner s = new Scanner(System.in);

        System.out.print("Please enter player one's name: ");
        String playerName1 = s.next();

        System.out.print("Please enter player two's name: ");
        String playerName2 = s.next();

        System.out.println("Starting game...");
        game.start(playerName1, playerName2);
        System.out.println("Game started!");

        game.printBoard();

        int[] from = new int[2];
        int[] to = new int[2];

        while (!(game.isGameDone())) {
            System.out.println(String.format("%s's (%s) turn to move", game.getPlayer(), game.getPlayer().getColor()));

            System.out.println("Coordinate of piece to move");

            getCoordinates(s, from);

            System.out.println("Coordinate of place to move");

            getCoordinates(s, to);

            // Create new move object
            Move move = new Move(game.getTile(from[0], from[1]), game.getTile(to[0], to[1]));

            // Validate move
            if (game.checkValidMove(move, game.getPlayer())) {
                System.out.println("Moving piece..");
            }

            game.nextTurn();
            game.printBoard();
        }

    }

    private static void getCoordinates(Scanner s, int[] coordinates) {
        System.out.print("    Enter X : ");
        coordinates[0] = s.nextInt() - 1;

        System.out.print("    Enter Y : ");
        coordinates[1] = s.nextInt() - 1;
    }
}
