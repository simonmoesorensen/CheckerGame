class OccupiedTile extends Tile {
    private final Piece piece;
    OccupiedTile(int x, int y, Piece piece) {
        super(x, y, Color.BLACK);
        this.piece = piece;
    }

    @Override
    public String toString() {
        return piece.toString();
    }

    public Piece getPiece() {
        return piece;
    }
}
