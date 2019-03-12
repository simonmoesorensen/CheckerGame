package Engine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

class MoveTest {
    private Move move;
    private Tile from;
    private Tile to;

    @BeforeEach
    void setUp() {
        Game game = new Game();
        game.start("bob", "ben");

        try {
            from = game.getTile(3, 3);
            to = game.getTile(4, 4);
            move = new Move(from, to);
        } catch (TileOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getFrom() {
        assertSame(from, move.getFrom());
    }

    @Test
    void getTo() {
        assertSame(to, move.getTo());
    }
}