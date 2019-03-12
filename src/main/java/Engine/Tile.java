package Engine;

public abstract class Tile {
    private final Color color;
    private int x;
    private int y;

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
