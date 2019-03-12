package Engine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveCheckerTest {
    private MoveChecker moveChecker;
    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
        game.start("bob", "ben");
    }

    @Test
    void getFrom() {
    }

    @Test
    void getTo() {
    }

    @Test
    void checkDiagonal() {

        try {
            Move moveNotDiagonal = new Move(game.getTile(3, 3), game.getTile(3, 2));
            Move moveFromOccupiedToVacant = new Move(game.getTile(3, 3), game.getTile(4, 4));

            moveChecker = new MoveChecker(moveNotDiagonal);

            assertThrows(DirectionException.class, () -> moveChecker.checkDiagonal());

            moveChecker = new MoveChecker(moveFromOccupiedToVacant);
            assertDoesNotThrow(() -> moveChecker.checkDiagonal());

        } catch (TileOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    @Test
    void checkRules() {

        try {
            Move moveNotDiagonal = new Move(game.getTile(3, 3), game.getTile(3, 2));
            Move moveFromOccupiedToVacant = new Move(game.getTile(3, 3), game.getTile(4, 4));

            moveChecker = new MoveChecker(moveNotDiagonal);
            assertFalse(moveChecker.checkRules());

            moveChecker = new MoveChecker(moveFromOccupiedToVacant);
            assertTrue(moveChecker.checkRules());

        } catch (TileOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}