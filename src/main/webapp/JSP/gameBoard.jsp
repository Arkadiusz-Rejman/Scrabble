<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="amk.scrabble.model.Tile" %>
<%@ page import="amk.scrabble.model.GameSession" %>
<%@ page import="amk.scrabble.model.BoardField" %>
<%@ page import="amk.scrabble.model.GameBoard" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Scrabble</title>
    <link rel="stylesheet" type="text/css" href="CSS/gameBoard.css">
    <script type="text/javascript" src="JS/gameBoard.js"></script>
   </head>
<body>



<!-- PLANSZA -->
<div class="ScrabbleBoard">
    <%
        GameBoard gameBoard = (GameBoard) request.getAttribute("gameBoard");
        BoardField[][] boardFields = gameBoard.getBoardFields();
    %>
    <table>
        <% for (int i = 0; i < 15; i++) { %>
        <tr>
            <% for (int j = 0; j < 15; j++) { %>
            <td ondrop="drop(event)" ondragover="allowDrop(event)">
                <div id="cell_<%= i %>_<%= j %>" class="cell" style="background-image: url('<%= boardFields[i][j].getTileOnField() != null ? boardFields[i][j].getTileOnField().getBackgroundImagePath() : boardFields[i][j].getImage() %>')">
                    <% if (boardFields[i][j].getTileOnField() != null) { %>
                    <%= boardFields[i][j].getTileOnField().getCharacter() %>
                    <span><%= boardFields[i][j].getTileOnField().getPoints() %></span>
                    <% } %>
                </div>
            </td>
            <% } %>
        </tr>
        <% } %>
    </table>
</div>


<div class="floater">
    <!-- TURY -->
    <div id="timer">secodnds left</div>
    <div id="player">
        Player <%= GameSession.get().getTurn().getPlayerTurn().getName() %> turn
    </div>

    <div id="score">Score: <%= GameSession.get().getTurn().getPlayerTurn().getScore() %> </div>  <!-- Jeszcze nie zrobione w CSS -->

    <!-- SKRABLE -->
    <div class="TileSack container">
        <% Tile[] tiles = (Tile[]) request.getAttribute("tiles"); %>
        <table>
            <tr>
                <% for (int j = 0; j < tiles.length; j++) { %>
                <td ondrop="drop(event)" ondragover="allowDrop(event)">
                    <div id="cell_<%= 20 %>_<%= j %>" class="cell">
                        <div class="tile" id="tile_<%= j %>" style="background-image: url('<%= tiles[j].getBackgroundImagePath() %>');" onclick="highlightTile(this)" draggable="true" ondragstart="dragStart(event)" data-index="<%= j %>">
                            <%= tiles[j].getCharacter() %>
                            <span><%= tiles[j].getPoints() %></span>
                        </div>
                    </div>
                </td>
                <% } %>
            </tr>
        </table>
        <button onclick="refreshPage()" class="button submit">Submit Moves</button>
    </div>

</div>

<div class="MessagesContainer">
    <% List<String> messages = GameSession.get().getMessagesManager().getMessages(); %>
    <div class="messages-list">
        <% for (int i = 0; i < messages.size(); i++) { %>
        <div id="message_<%= i %>" class="message-item"><%= messages.get(i) %></div>
        <% } %>
    </div>
</div>


</body>
</html>

