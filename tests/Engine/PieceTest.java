package Engine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest {
    private Piece whitePiece;
    private Piece blackPiece;

    @BeforeEach
    void setUp() {
        whitePiece = new PlainPiece(Color.WHITE);
        blackPiece = new PlainPiece(Color.BLACK);
    }

    @Test
    void getColor() {
        assertEquals(Color.WHITE, whitePiece.getColor());
        assertEquals(Color.BLACK, blackPiece.getColor());
        assertNotEquals(Color.BLACK, whitePiece.getColor());
        assertNotEquals(Color.WHITE, blackPiece.getColor());
    }

    @Test
    void isOwnedBy() {
        Player blackPlayer = new Player(Color.BLACK, "blackDude");
        Player whitePlayer = new Player(Color.WHITE, "whiteDude");

        assertTrue(whitePiece.isOwnedBy(whitePlayer));
        assertTrue(blackPiece.isOwnedBy(blackPlayer));
        assertFalse(whitePiece.isOwnedBy(blackPlayer));
        assertFalse(blackPiece.isOwnedBy(whitePlayer));

    }

    @Test
    void testToString() {
        assertEquals("[W]", whitePiece.toString());
        assertEquals("[B]", blackPiece.toString());
        assertNotEquals("[B]", whitePiece.toString());
        assertNotEquals("[W]", blackPiece.toString());
    }
}