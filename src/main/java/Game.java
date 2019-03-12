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
        players[0] = new Player(Color.WHITE);
        players[1] = new Player(Color.BLACK);
    }

    public void printBoard() {
        BoardPrinter.print(board.getBoard());
    }

    public void stop() {
        // TODO: Stop game
    }

    public void checkValidMove(Move move, Player player) {
        MoveChecker moveChecker = new MoveChecker(move);
        TileChecker tileCheckerFrom = new TileChecker(moveChecker.getFrom());
        TileChecker tileCheckerTo = new TileChecker(moveChecker.getTo());

        // Check ownership
        try {
            tileCheckerFrom.isOwner(((OccupiedTile) tileCheckerFrom.getTile()).getPiece(), player);
        } catch (PieceOwnershipException e) {
            System.out.println(e);
            return;
        }

        //
        if (!(moveChecker.checkRules() && tileCheckerTo.checkRules())) {
            return;
        }

        // TODO: Check for valid moves using MoveChecker
        if (!(moveChecker.checkRules())) {
            return;
        }
        movePiece(moveChecker.getFrom(), moveChecker.getTo());

    }

    private void movePiece(Tile from, Tile to) {
        // TODO: Actual Move logic

    }

}
