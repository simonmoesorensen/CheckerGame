abstract class Tile {
    private int x;
    private int y;
    private final Color color;

    Tile(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
