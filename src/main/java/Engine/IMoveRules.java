package Engine;

public interface IMoveRules extends IRules {
    void checkDiagonal() throws DirectionException;
}
