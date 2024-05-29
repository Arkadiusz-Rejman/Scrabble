<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="amk.scrabble.model.Tile" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Scrabble</title>
    <link rel="stylesheet" type="text/css" href="CSS/gameBoard.css">
    <script type="text/javascript" src="JS/gameBoard.js"></script>
</head>
<body>
<h1>Losowe kafelki</h1>
<div id="tile-container" ondrop="drop(event)" ondragover="allowDrop(event)">
    <% List<Tile> tiles = (List<Tile>) request.getAttribute("tiles"); %>
    <% for (int i = 0; i < tiles.size(); i++) { %>
    <div class="tile" id="tile_<%= i %>" style="background-image: url('<%= tiles.get(i).getBackgroundImagePath() %>');" onclick="highlightTile(this)" draggable="true" ondragstart="dragStart(event)">
        <%= tiles.get(i).getCharacter() %>
        <span><%= tiles.get(i).getPoints() %></span>
    </div>
    <% } %>
</div>
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