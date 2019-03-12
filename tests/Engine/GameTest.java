package Engine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
        game.start("bob", "ben");
    }

    @Test
    void nextTurn() {
        assertEquals(0, game.getPlayerTurn());
        game.nextTurn();
        assertEquals(1, game.getPlayerTurn());
        game.nextTurn();
        assertEquals(0, game.getPlayerTurn());
    }

    @Test
    void getTile() {
        assertThrows(TileOutOfBoundsException.class, () -> game.getTile(123, 1));
        assertThrows(TileOutOfBoundsException.class, () -> game.getTile(1, 8));
        assertDoesNotThrow(() -> {
            game.getTile(1, 7);
        });

        try {
            assertTrue(game.getTile(2, 2) instanceof OccupiedTile);
            assertTrue(game.getTile(1, 2) instanceof VacantTile);
        } catch (TileOutOfBoundsException e) {
            // Just needed something here
            assertTrue(e instanceof TileOutOfBoundsException);
        }
    }

    @Test
    void getPlayer() {
        Player[] players = game.getPlayers();

        assertSame(players[0], game.getPlayer());
        game.nextTurn();
        assertSame(players[1], game.getPlayer());
    }

    @Test
    void start() {
        assertEquals("bob", game.getPlayer().getName());
        game.nextTurn();
        assertEquals("ben", game.getPlayer().getName());
    }

    @Test
    void isGameDone() {
        // Not implemented in logic
    }

    @Test
    void printBoard() {
        // Cant test
    }

    @Test
    void stop() {
        // Not implemented as game can never end so far
    }

    @Test
    void checkValidMove() {
        try {
            Move moveFromOccupiedToVacant = new Move(game.getTile(2, 2), game.getTile(3, 3));
            Move moveFromVacantToOccupied = new Move(game.getTile(3, 3), game.getTile(2, 2));
            Move moveFromOccupiedToOccupied = new Move(game.getTile(1, 1), game.getTile(2, 2));
            Move moveBlackPiece = new Move(game.getTile(1, 5), game.getTile(2, 4));
            Move moveNotDiagonal = new Move(game.getTile(2, 2), game.getTile(2, 1));
            Player[] players = game.getPlayers();

            assertTrue(game.checkValidMove(moveFromOccupiedToVacant, players[0]));
            assertFalse(game.checkValidMove(moveFromVacantToOccupied, players[0]));
            assertFalse(game.checkValidMove(moveFromOccupiedToOccupied, players[0]));
            assertFalse(game.checkValidMove(moveBlackPiece, players[0]));
            assertFalse(game.checkValidMove(moveFromOccupiedToOccupied, players[1]));
            assertFalse(game.checkValidMove(moveNotDiagonal, players[0]));


        } catch (TileOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getPlayerTurn() {
        assertEquals(0, game.getPlayerTurn());
        game.nextTurn();
        assertEquals(1, game.getPlayerTurn());
    }
}