package Engine;

import Engine.Board;
import Engine.BoardInitializer;
import Engine.BoardPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoardPrinterTest {
    private Board board = new Board();

    @BeforeEach
    void setUp() {
        BoardInitializer.initializeBoard(board.getBoard());
    }

    @Test
    void print() {
        // Not really an actual test, but can be used to verify the printed board's layout
        BoardPrinter.print(board.getBoard());
    }
}