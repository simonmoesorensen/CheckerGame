class VacantTile extends Tile {
    VacantTile(int x, int y) {
        super(x, y, Color.WHITE);
    }

    @Override
    public String toString() {
        return "[ ]";
    }
}
