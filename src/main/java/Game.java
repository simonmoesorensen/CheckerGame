public class Game {
    private Player[] players = new Player[2];
    private Board board = new Board();

    // TODO: Insert game logic

    // TODO: Store player turn as field
    // TODO: Store players as fields
    // TODO: Unit testing


    public void start() {
        // TODO: Start game
        BoardInitializer.initializeBoard(board.getBoard());
    }

    public void printBoard() {
        BoardPrinter.print(board.getBoard());
    }

    public void stop() {
        // TODO: Stop game
    }

    public void checkValidMove(MoveChecker moveChecker) {
        // TODO: Check for valid moves using MoveChecker
    }

    public void movePiece(OccupiedTile from, VacantTile to) {
        // TODO: Use MoveChecker to check for moves
    }

    // TODO: TileChecker
}
