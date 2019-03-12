public class Game {
    private Player[] players = new Player[2];
    private Board board = new Board();
    private int playerTurn = 0;

    // TODO: Insert game logic

    // TODO: Unit testing

    public void nextTurn() {
        switch (playerTurn) {
            case 0:
                playerTurn = 1;
                break;
            case 1:
                playerTurn = 0;
                break;
            default:
                break;
        }
    }

    public Tile getTile(int x, int y) {
        return board.getBoard()[y][x];
    }

    public Player getPlayer() {
        return players[playerTurn];
    }

    public void start(String playername1, String playername2) {
        BoardInitializer.initializeBoard(board.getBoard());
        players[0] = new Player(Color.WHITE, playername1);
        players[1] = new Player(Color.BLACK, playername2);
    }

    public boolean isGameDone() {
        return (board.getBlackPieces() == 0 || board.getWhitePieces() == 0);
    }

    public void printBoard() {
        BoardPrinter.print(board.getBoard());
    }

    public void stop() {
        // Display wining player, didn't have time to implement
        if (players[0].getScore() > players[1].getScore()) {
            System.out.println(String.format("The winner is... %s!", players[0]));
        } else {
            System.out.println(String.format("The winner is... %s!", players[1]));
        }
        board = null;
        players = null;
    }

    public boolean checkValidMove(Move move, Player player) {
        MoveChecker moveChecker = new MoveChecker(move);
        TileChecker tileCheckerFrom = new TileChecker(moveChecker.getFrom());
        TileChecker tileCheckerTo = new TileChecker(moveChecker.getTo());

        // Check ownership
        try {
            tileCheckerFrom.isOwner(((OccupiedTile) tileCheckerFrom.getTile()).getPiece(), player);
        } catch (PieceOwnershipException e) {
            System.out.println(e);
            return false;
        }

        // Check that all rules apply
        if (!(moveChecker.checkRules() && tileCheckerTo.checkRules())) {
            return false;
        }

        movePiece(moveChecker.getFrom(), moveChecker.getTo());
        return true;
    }

    private void movePiece(Tile from, Tile to) {
        Tile[][] board = this.board.getBoard();
        board[to.getY()][to.getX()] = board[from.getY()][from.getX()];
        board[from.getY()][from.getX()] = new VacantTile(from.getX(), from.getY());
    }

    public int getPlayerTurn() {
        return playerTurn;
    }
}
