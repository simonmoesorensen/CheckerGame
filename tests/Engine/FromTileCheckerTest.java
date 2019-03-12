package Engine;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FromTileCheckerTest {
    FromTileChecker fromTileChecker;

    @BeforeEach
    void setUp() {
        fromTileChecker = new FromTileChecker(new VacantTile(1, 2));
    }

    @Test
    void isOccupied() {
    }

    @Test
    void checkOccupied() {
//        assertThrows(VacantTileException, () -> fromTileChecker.checkOccupied());

    }

    @Test
    void checkOwner() {
    }

    @Test
    void checkRules() {
    }
}