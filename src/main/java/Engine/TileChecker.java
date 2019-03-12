package Engine;

abstract class TileChecker implements ITileRules {
    private Tile tile;

    TileChecker(Tile tile) {
        this.tile = tile;
    }

    public Tile getTile() {
        return tile;
    }

    @Override
    abstract public boolean checkRules();
}
