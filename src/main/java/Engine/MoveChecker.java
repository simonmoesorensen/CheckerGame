package Engine;

class MoveChecker implements IMoveRules {
    private Tile from;
    private Tile to;

    MoveChecker(Move move) {
        this.from = move.getFrom();
        this.to = move.getTo();
    }

    public Tile getFrom() {
        return from;
    }

    public Tile getTo() {
        return to;
    }

    @Override
    public void checkDiagonal() throws DirectionException {
        if (Math.abs(to.getX() - from.getX()) != Math.abs(to.getY() - from.getY())) {
            throw new DirectionException("Engine.Move is not diagonal");
        }
    }

    @Override
    public boolean checkRules() {
        try {
            checkDiagonal();
            return true;
        } catch (GameException e) {
            System.out.println(e);
            return false;
        }
    }
}
