package Engine;

public class ToTileChecker extends TileChecker {
    ToTileChecker(Tile tile) {
        super(tile);
    }

    void checkVacancy() throws OccupiedTileException {
        if (this.getTile() instanceof OccupiedTile) {
            throw new OccupiedTileException(String.format("Tile (%d, %d) is occupied",
                    this.getTile().getX() + 1, this.getTile().getY() + 1));
        }
    }

    @Override
    public boolean checkRules() {
        try {
            checkVacancy();
            return true;
        } catch (OccupiedTileException e) {
            System.out.println(e);
            return false;
        }
    }


}
