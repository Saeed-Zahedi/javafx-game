package ir.ac.kntu;

public class Player {
    public String name;
    public int score;

    public Player(String name) {
        this.name = name;
        AllPlayers.AllPlayers.add(this);
    }

    @Override
    public String toString() {
        return
                "player: " + name ;
    }
}
