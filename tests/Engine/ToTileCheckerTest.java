package Engine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToTileCheckerTest {
    private ToTileChecker occupiedTileChecker;
    private ToTileChecker vacantTileChecker;

    @BeforeEach
    void setUp() {
        occupiedTileChecker = new ToTileChecker(
                new OccupiedTile(3, 3,
                        new PlainPiece(Color.WHITE)));

        vacantTileChecker = new ToTileChecker(
                new VacantTile(3, 3));
    }

    @Test
    void checkVacancy() {
        assertThrows(OccupiedTileException.class, () -> occupiedTileChecker.checkVacancy());

        assertDoesNotThrow(() -> vacantTileChecker.checkVacancy());

    }

    @Test
    void checkRules() {
        assertFalse(occupiedTileChecker.checkRules());
        assertTrue(vacantTileChecker.checkRules());
    }
}