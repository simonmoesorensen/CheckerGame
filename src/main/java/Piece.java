abstract class Piece {
    private Color color;

    Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public boolean isOwnedBy(Player player) {
        return player.getColor() == color;
    }

    @Override
    public String toString() {
        switch (color) {
            case WHITE:
                return "[W]";
            case BLACK:
                return "[B]";
        }
        return null;
    }

}
