public enum Color {
    WHITE, BLACK;

    @Override
    public String toString() {
        switch (this) {
            case WHITE:
                return "White";
            case BLACK:
                return "Black";
        }
        return null;
    }
}
