package Engine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FromTileCheckerTest {
    private FromTileChecker fromTileCheckerVacant;
    private FromTileChecker fromTileCheckerOccupied;
    private Player blackPlayer;
    private Player whitePlayer;

    @BeforeEach
    void setUp() {
        fromTileCheckerVacant = new FromTileChecker(new VacantTile(1, 2));
        fromTileCheckerOccupied = new FromTileChecker(new OccupiedTile(1, 2, new PlainPiece(Color.BLACK)));
        blackPlayer = new Player(Color.BLACK, "carl");
        whitePlayer = new Player(Color.WHITE, "segan");
    }

    @Test
    void isOccupied() {
        assertTrue(fromTileCheckerOccupied.isOccupied());
        assertFalse(fromTileCheckerVacant.isOccupied());
    }

    @Test
    void checkOccupied() {
        assertThrows(VacantTileException.class, () -> fromTileCheckerVacant.checkOccupied());
        assertDoesNotThrow(() -> fromTileCheckerOccupied.checkOccupied());
    }

    @Test
    void checkOwner() {
        OccupiedTile tile = ((OccupiedTile) fromTileCheckerOccupied.getTile());
        assertThrows(PieceOwnershipException.class, () -> fromTileCheckerOccupied.checkOwner(tile.getPiece(), whitePlayer));
        assertDoesNotThrow(() -> fromTileCheckerOccupied.checkOwner(tile.getPiece(), blackPlayer));
    }

    @Test
    void checkRules() {
        assertFalse(fromTileCheckerVacant.checkRules());
        assertTrue(fromTileCheckerOccupied.checkRules());
    }
}