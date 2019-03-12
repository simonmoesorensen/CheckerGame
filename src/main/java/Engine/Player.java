package Engine;

public class Player {
    private Color color;
    private int score = 0;
    private String name;

    public Player(Color color, String name) {
        this.color = color;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return name;
    }
}
