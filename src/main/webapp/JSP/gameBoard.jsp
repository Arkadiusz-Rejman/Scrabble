<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="amk.scrabble.model.Tile" %>
<%@ page import="amk.scrabble.model.GameSession" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Scrabble</title>
    <link rel="stylesheet" type="text/css" href="CSS/gameBoard.css">
    <script type="text/javascript" src="JS/gameBoard.js"></script>
</head>
<body>
<h1>SKRABLE!</h1>

<!-- TURY -->
<div id="timer">30 seconds left</div>
<div id="player">
    Player <%= GameSession.get().getTurn().getPlayerTurn().getName() %> turn
</div>

<!-- SKRABLE -->
<div class="TileSack">
    <% Tile[] tiles = (Tile[]) request.getAttribute("tiles"); %>
    <table>
        <tr>
            <% for (int j = 0; j < 8; j++) { %>
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
    <button onclick="">Submit Moves</button>
</div>


<!-- PLANSZA -->
<div class="ScrabbleBoard">
    <table>
        <% for (int i = 0; i < 15; i++) { %>
        <tr>
            <% for (int j = 0; j < 15; j++) { %>
            <td ondrop="drop(event)" ondragover="allowDrop(event)">
                <div id="cell_<%= i %>_<%= j %>" class="cell"></div>
            </td>
            <% } %>
        </tr>
        <% } %>
    </table>
    <button onclick="">Submit Moves</button>
</div>
</body>
</html>