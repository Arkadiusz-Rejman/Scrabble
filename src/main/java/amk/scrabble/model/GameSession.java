package amk.scrabble.model;

import javax.swing.text.MaskFormatter;
import java.util.ArrayList;
import java.util.List;

public class GameSession {

    private List<Player> players;
    private GameBoard gameBoard;
    private Turn turn;
    private TileSack tileSack;
    private MessagesManager messagesManager;
    private static GameSession gameSession;


    private GameSession(){
    }


    //STATIC
    public static void createNew(){ gameSession = new GameSession(); }
    public static GameSession get(){ return gameSession; }
    public static void shutdown() { gameSession = null; }



    //OBJ
    public List<Player> getPlayers() {
        return gameSession.players;
    }
    public void setPlayers(List<Player> players) {
        gameSession.players = players;
    }


    public int getActivePlayersCount(){
        return (int) gameSession.players.stream().filter(player -> !player.isResigned()).count();
    }

    public MessagesManager getMessagesManager() { return messagesManager; }
    public void setMessagesManager(MessagesManager messagesManager) { gameSession.messagesManager = messagesManager; }

    public GameBoard getGameBoard(){ return gameSession.gameBoard; }
    public void setGameBoard(GameBoard gameBoard) { gameSession.gameBoard = gameBoard; }

    public TileSack getTileSack() { return gameSession.tileSack; }
    public void setTileSack(TileSack tileSack) { gameSession.tileSack = tileSack; }
    public Turn getTurn() { return gameSession.turn; }

    public void setTurn(Turn turn) { gameSession.turn = turn; }
    public void changeTurn() {
        int actualPlayerTurnIndex = gameSession.players.indexOf(gameSession.turn.getPlayerTurn());
        int nextPlayerIndex = (actualPlayerTurnIndex + 1) % gameSession.players.size();

        while (gameSession.players.get(nextPlayerIndex).isResigned()) {
            nextPlayerIndex = (nextPlayerIndex + 1) % gameSession.players.size();
        }

        gameSession.setTurn(new Turn(gameSession.players.get(nextPlayerIndex)));


    }
}
