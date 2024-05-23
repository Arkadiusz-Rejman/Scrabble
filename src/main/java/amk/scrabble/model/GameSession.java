package amk.scrabble.model;

import java.util.ArrayList;
import java.util.List;

public class GameSession {
    private List<Player> players;

    public GameSession() {
        players = new ArrayList<>();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

}
