package Engine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ITileRulesTest {

    @Test
    void checkWall() {
        assertThrows(TileOutOfBoundsException.class, () -> ITileRules.checkWall(123, 1));
        assertThrows(TileOutOfBoundsException.class, () -> ITileRules.checkWall(1, 8));
        assertDoesNotThrow(() -> ITileRules.checkWall(1, 7));
    }
}