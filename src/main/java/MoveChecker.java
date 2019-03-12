class MoveChecker implements IMoveRules {
    private Tile from;
    private Tile to;

    // TODO: Implement move rules, split into many different functions for unit testing
    // TODO: Implement exception

    MoveChecker(Tile from, Tile to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void checkDiagonal() throws DirectionException {
        if (Math.abs(to.getX() - from.getX()) != Math.abs(to.getY() - from.getY())) {
            throw new DirectionException("Move is not diagonal");
        }
    }

    @Override
    public void checkWall() throws TileOutOfBoundsException {
        if (((to.getY() > 7) || (to.getY() < 0)) || ((to.getX() > 7) || (to.getX() < 0))) {
            throw new TileOutOfBoundsException(String.format("Tile (%d, %d) is out of bounds",
                    to.getX(), to.getY()));
        }
    }

    @Override
    public void checkVacancy() throws OccupiedTileException {
        if (to instanceof OccupiedTile) {
            throw new OccupiedTileException(String.format("Tile (%d, %d) is occupied",
                    to.getX(), to.getY()));
        }
    }

    @Override
    public void checkRules() {

        // TODO: Print proper exception stack trace
        try {
            checkWall();
            checkVacancy();
            checkDiagonal();
        } catch (TileOutOfBoundsException e) {
            e.printStackTrace();
        } catch (OccupiedTileException e) {
            e.printStackTrace();
        } catch (DirectionException e) {
            e.printStackTrace();
        }
    }
}
