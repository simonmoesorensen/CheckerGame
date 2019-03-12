package Engine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class TileTest {
    private Tile tile;

    @BeforeEach
    void setUp() {
        tile = new VacantTile(3, 4);
    }

    @Test
    void getX() {
        assertEquals(3, tile.getX());
        assertNotEquals(22, tile.getX());

    }

    @Test
    void getY() {
        assertEquals(4, tile.getY());
        assertNotEquals(2123, tile.getY());
    }
}