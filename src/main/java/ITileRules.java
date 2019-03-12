interface ITileRules extends IRules {
    void isOwner(Piece piece, Player player) throws PieceOwnershipException;
    void checkWall() throws TileOutOfBoundsException;
    void checkVacancy() throws OccupiedTileException;
}
