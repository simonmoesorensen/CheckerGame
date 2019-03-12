import Engine.Game;
import Engine.Move;
import Engine.Tile;
import Engine.TileOutOfBoundsException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    private static Game game;
    private static Scanner s;

    public static void main(String[] args) {
        game = new Game();

        s = new Scanner(System.in);

        System.out.print("Please enter player one's name: ");
        String playerName1 = s.next();

        System.out.print("Please enter player two's name: ");
        String playerName2 = s.next();

        System.out.println("Starting game...");
        game.start(playerName1, playerName2);
        System.out.println("Engine.Game started!");

        game.printBoard();

        int[] from = new int[2];
        int[] to = new int[2];

        while (!(game.isGameDone())) {
            System.out.println(String.format("%s's (%s) turn to move", game.getPlayer(), game.getPlayer().getColor()));

            System.out.println("Coordinate of piece to move");

            getCoordinates(from);

            Tile fromTile = getTile(from);

            System.out.println("Coordinate of place to move");

            getCoordinates(to);

            Tile toTile = getTile(to);

            // Create new move object
            Move move = new Move(fromTile, toTile);

            // Validate move
            if (game.checkValidMove(move, game.getPlayer())) {
                System.out.println("Moving piece..");

                game.nextTurn();

            } else {
                System.out.println("Try again");
            }

            game.printBoard();

        }

        game.stop();

    }

    private static Tile getTile(int[] from) {
        try {
            return game.getTile(from[0], from[1]);
        } catch (TileOutOfBoundsException e) {
            System.out.println(e);
            System.out.println("Try again");
            getCoordinates(from);
            return getTile(from);
        }
    }

    private static void getCoordinates(int[] coordinates) {
        try {
            System.out.print("    Enter X : ");
            coordinates[0] = s.nextInt() - 1;

            System.out.print("    Enter Y : ");
            coordinates[1] = s.nextInt() - 1;
        } catch (InputMismatchException e) {
            System.out.println("Wrong input, try again");
            s.next();
            getCoordinates(coordinates);
        }
    }
}
