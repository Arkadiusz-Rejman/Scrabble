package amk.scrabble.model;

import java.util.ArrayList;
import java.util.List;

public class GameSession {

    private List<Player> players;
//    private GameBoard gameBoard;
    private TileSack tileSack;
    private Player playerTurn;
    private static GameSession gameSession;

    private GameSession(){}


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

//    public GameBoard getGameBoard(){ return gameSession.gameBoard; }
//    public void setGameBoard(GameBoard gameBoard) { gameSession.gameBoard = gameBoard; }

    public TileSack getTileSack() { return gameSession.tileSack; }
    public void setTileSack(TileSack tileSack) { gameSession.tileSack = tileSack; }

    public Player getPlayerTurn() { return gameSession.playerTurn; }
    public void setPlayerTurn(Player playerTurn) { gameSession.playerTurn = playerTurn; }
    public void changeTurn() {
        int actuallPlayerTurnIndex = gameSession.players.indexOf(gameSession.playerTurn);
        if(actuallPlayerTurnIndex == gameSession.players.size() - 1){
            gameSession.playerTurn = gameSession.players.get(0);
        }else {
            gameSession.playerTurn = gameSession.players.get(actuallPlayerTurnIndex + 1);
        }

    }
}
