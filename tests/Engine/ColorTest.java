package Engine;

import Engine.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ColorTest {

    @Test
    public void testToString() {
        Color white = Color.WHITE;
        Color black = Color.BLACK;

        assertEquals("White", white.toString());
        assertEquals("Black", black.toString());
    }

}