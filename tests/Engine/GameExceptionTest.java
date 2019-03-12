package Engine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameExceptionTest {

    @Test
    void testToString() {
        assertEquals("test", new GameException("test").toString());
    }
}