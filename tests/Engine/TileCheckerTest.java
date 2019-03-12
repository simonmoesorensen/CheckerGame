package Engine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

class TileCheckerTest {
    private Tile tile;

    @BeforeEach
    void setUp() {
        tile = new VacantTile(3, 3);
    }

    @Test
    void getTile() {
        assertSame(tile, new FromTileChecker(tile).getTile());
        assertSame(tile, new ToTileChecker(tile).getTile());
    }
}