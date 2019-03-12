public interface IMoveRules extends IRules {
    void checkDiagonal() throws DirectionException;
    void checkWall() throws TileOutOfBoundsException;
    void checkVacancy() throws OccupiedTileException;

}
