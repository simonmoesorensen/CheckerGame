package Engine;

public class FromTileChecker extends TileChecker {
    FromTileChecker(Tile tile) {
        super(tile);
    }

    public boolean isOccupied() {
        return (this.getTile() instanceof OccupiedTile);
    }

    public void checkOccupied() throws VacantTileException {
        if (this.getTile() instanceof VacantTile) {
            throw new VacantTileException(String.format("Engine.Tile (%d, %d) is not a piece",
                    this.getTile().getX() + 1, this.getTile().getY() + 1));
        }
    }

    public void checkOwner(Piece piece, Player player) throws PieceOwnershipException {
        if (piece.getColor() != player.getColor()) {
            throw new PieceOwnershipException(String.format("%s piece is not owned by %s",
                    player.getColor(),
                    player.getName()));
        }
    }

    @Override
    public boolean checkRules() {
        try {
            checkOccupied();
            return true;
        } catch (VacantTileException e) {
            System.out.println(e);
            return false;
        }
    }
}
