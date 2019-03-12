class TileChecker implements ITileRules {
    private Tile tile;

    TileChecker(Tile tile) {
        this.tile = tile;
    }

    public Tile getTile() {
        return tile;
    }

    @Override
    public void isOwner(Piece piece, Player player) throws PieceOwnershipException {
        if (piece.getColor() != player.getColor()) {
            throw new PieceOwnershipException("Piece is not owned by " + player.getColor());
        }
    }

    @Override
    public void checkWall() throws TileOutOfBoundsException {
        if (((tile.getY() > 7) || (tile.getY() < 0)) || ((tile.getX() > 7) || (tile.getX() < 0))) {
            throw new TileOutOfBoundsException(String.format("Tile (%d, %d) is out of bounds",
                    tile.getX() + 1, tile.getY() + 1));
        }
    }

    @Override
    public void checkVacancy() throws OccupiedTileException {
        if (tile instanceof OccupiedTile) {
            throw new OccupiedTileException(String.format("Tile (%d, %d) is occupied",
                    tile.getX() + 1, tile.getY() + 1));
        }
    }

    @Override
    public boolean checkRules() {

        try {
            checkWall();
            checkVacancy();
            return true;
        } catch (GameException e) {
            System.out.println(e);
            return false;
        }
    }
}
