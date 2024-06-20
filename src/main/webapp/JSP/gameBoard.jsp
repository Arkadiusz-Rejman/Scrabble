<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="amk.scrabble.model.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Scrabble</title>
    <link rel="stylesheet" type="text/css" href="CSS/gameBoard.css">
    <script type="text/javascript" src="JS/gameBoard.js"></script>
   </head>
<body>


<div class="gra">
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
    <!-- PEDLA DO DIV DOCKOW -->
    <%  int offset = 0;%>
    <% for(int i=0;i< GameSession.get().getPlayers().size();i++){%>
    <!-- SKRABLE -->
    <div class="TileSack container_<%=i%>">
        <% Tile[] tiles = (Tile[]) GameSession.get().getPlayers().get(i).getDock(); %>
        <p class="player_name">Name: <%= GameSession.get().getPlayers().get(i).getName() %></p>
        <p class="player_score">Score: <%= GameSession.get().getPlayers().get(i).getScore() %></p>
                <table>
                    <tr>
                        <% for (int j = 0; j < tiles.length; j++) { %>
                        <td ondrop="drop(event)" ondragover="allowDrop(event)">
                            <div id="cell_<%= 20 + i %>_<%= j + i %>" class="cell">
                                <div class="tile" id="tile_<%= j + offset%>" style="background-image: url('<%= tiles[j].getBackgroundImagePath() %>');" onclick="highlightTile(this)" draggable="true" ondragstart="dragStart(event)" data-index="<%= j%>">
                                    <%= tiles[j].getCharacter() %>
                                    <span><%= tiles[j].getPoints() %></span>
                                </div>
                            </div>
                        </td>
                        <% } %>
                    </tr>
                </table>
    </div>
    <!-- KONIEC SCRABLE -->
    <% offset += 10;  %>
    <%}%>
    <!-- KONIEC FOR -->
</div>

<div class="floater2">

    <!-- TURY -->
    <div id="timer">secodnds left</div>
    <div id="player">Player <%=GameSession.get().getTurn().getPlayerTurn().getName()%> turn</div>
    <button onclick="refreshPage()" class="button submit">Submit Moves</button>
    <div class="MessagesContainer">
        <% List<String> messages = GameSession.get().getMessagesManager().getMessages(); %>
        <div class="messages-list">
            <% for (int i = 0; i < messages.size(); i++) { %>
            <div id="message_<%= i %>" class="message-item"><%= messages.get(i) %></div>
            <% } %>
        </div>
    </div>
</div>
</div>
</body>
</html>

