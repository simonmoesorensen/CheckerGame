final class Board {
    private Tile[][] board = new Tile[8][8];
    private int whitePieces = 12;
    private int blackPieces = 12;

    Tile[][] getBoard() {
        return board;
    }

    public void killWhitePiece() {
        whitePieces--;
    }
    public void killBlackPiece() {
        blackPieces--;
    }

    public int getWhitePieces() {
        return whitePieces;
    }

    public int getBlackPieces() {
        return blackPieces;
    }
}
