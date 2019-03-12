package Engine;

class GameException extends Exception {
    String msg;

    GameException(String msg) {
        super();
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}
