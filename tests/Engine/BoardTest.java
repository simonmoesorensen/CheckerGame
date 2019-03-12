package Engine;

import Engine.Board;
import Engine.Tile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BoardTest {
    Board board = new Board();


    @Test
    void getBoard() {
        assertEquals(new Tile[8][8].length, board.getBoard().length);
    }

    @Test
    void killWhitePiece() {
        int white1 = board.getWhitePieces();
        board.killWhitePiece();
        assertTrue(white1 > board.getWhitePieces());
    }

    @Test
    void killBlackPiece() {
        int black1 = board.getBlackPieces();
        board.killBlackPiece();
        assertTrue(black1 > board.getBlackPieces());
    }

    @Test
    void getWhitePieces() {
        assertEquals(12, new Board().getWhitePieces());
    }

    @Test
    void getBlackPieces() {
        assertEquals(12, new Board().getBlackPieces());

    }
}