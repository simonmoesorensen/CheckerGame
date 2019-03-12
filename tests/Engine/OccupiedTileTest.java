package Engine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OccupiedTileTest {
    private Tile whiteTile;
    private Tile blackTile;

    @BeforeEach
    void setUp() {
        Game game = new Game();
        game.start("bob", "ben");
        try {
            whiteTile = game.getTile(2, 2);
            blackTile = game.getTile(1, 5);
        } catch (TileOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testToString() {
        assertEquals("[W]", whiteTile.toString());
        assertEquals("[B]", blackTile.toString());
        assertNotEquals("[B]", whiteTile.toString());
        assertNotEquals("[W]", blackTile.toString());
    }

    @Test
    void getPiece() {
        assertFalse(blackTile instanceof VacantTile);

        if (whiteTile instanceof OccupiedTile) {
            assertNotNull(((OccupiedTile) whiteTile).getPiece());
        }
    }
}