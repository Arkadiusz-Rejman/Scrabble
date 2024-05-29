<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="amk.scrabble.model.Tile" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Scrabble</title>
    <link rel="stylesheet" type="text/css" href="CSS/gameBoard.css">
</head>
<body>
    <h1>Losowe kafelki</h1>
    <div>
        <% List<Tile> tiles = (List<Tile>) request.getAttribute("tiles"); %>
        <% for (Tile tile : tiles) { %>
            <div class="tile" style="background-image: url('<%= tile.getBackgroundImagePath() %>');" onclick="highlightTile(this)">
                <%= tile.getCharacter() %>
                <span><%= tile.getPoints() %></span>
            </div>
        <% } %>
    </div>
    <div class="ScrabbleBoard">
        <table>
            <% for (int i = 0; i < 15; i++) { %>
            <tr>
                <% for (int j = 0; j < 15; j++) { %>
                <td>
                    <input type="text" name="field_<%=i %>_<%=j %>" id="field_<%=i %>_<%=j %>"/>
                </td>
                <% } %>
            </tr>
            <% } %>
        </table>
        <button onclick="">Submit Moves</button>
    </div>
    <script>
        function highlightTile(element) {

            document.querySelectorAll('.tile').forEach(tile => {
                tile.classList.remove('highlighted');
            });

            element.classList.add('highlighted');
        }
    </script>
</body>
</html>
