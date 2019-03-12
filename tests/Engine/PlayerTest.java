package Engine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PlayerTest {
    private Player blackPlayer = new Player(Color.BLACK, "blackDude");
    private Player whitePlayer = new Player(Color.WHITE, "whiteDude");

    @Test
    void getName() {
        assertEquals("blackDude", blackPlayer.getName());
        assertEquals("whiteDude", whitePlayer.getName());
        assertNotEquals("blackDude", whitePlayer.getName());
        assertNotEquals("whiteDude", blackPlayer.getName());
    }

    @Test
    void getColor() {
        assertEquals(Color.BLACK, blackPlayer.getColor());
        assertEquals(Color.WHITE, whitePlayer.getColor());
        assertNotEquals(Color.BLACK, whitePlayer.getColor());
        assertNotEquals(Color.WHITE, blackPlayer.getColor());
    }

    @Test
    void getScore() {
        // Not implemented
    }

    @Test
    void setScore() {
        // Not implemented
    }

    @Test
    void testToString() {
        assertEquals("blackDude", blackPlayer.toString());
        assertEquals("whiteDude", whitePlayer.toString());
        assertNotEquals("blackDude", whitePlayer.toString());
        assertNotEquals("whiteDude", blackPlayer.toString());
    }
}