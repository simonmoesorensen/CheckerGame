interface ITileRules extends IRules {
    static void checkWall(int x, int y) throws TileOutOfBoundsException {
        if (((y > 7) || (y < 0)) || ((x > 7) || (x < 0))) {
            throw new TileOutOfBoundsException(String.format("Tile (%d, %d) is out of bounds",
                    x + 1, y + 1));
        }
    }
}
