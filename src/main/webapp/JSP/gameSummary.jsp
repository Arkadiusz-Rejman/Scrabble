
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="amk.scrabble.model.*" %>
<%@ page import="java.util.Comparator" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Summary Screen</title>
    <link rel="stylesheet" type="text/css" href="CSS/gameSummary.css">
    <script type="text/javascript" src="JS/gameSummary.js"></script>
</head>
<body onload="noBack()" onpageshow="if (event.persisted) noBack();">
<div class="container">
    <h1>GAME SUMMARY</h1>
    <%
        List<Player> players = GameSession.get().getPlayers().stream().sorted(Comparator
                .comparingInt(Player::getScore).reversed()).collect(Collectors.toList());
        if (!players.isEmpty()) {
    %>
    <div class="player first-place">
        <p>Player: <%= players.get(0).getName() %></p>
        <p>Score: <%= players.get(0).getScore() %></p>
        <p class="place">Place: 1st</p>
    </div>
    <%
        }
        if (players.size() > 1) {
    %>
    <div class="second-third-fourth">
        <% if (players.size() > 1) { %>
        <div class="player second-place">
            <p>Player: <%= players.get(1).getName() %></p>
            <p>Score: <%= players.get(1).getScore() %></p>
            <p class="place">Place: 2nd</p>
        </div>
        <% } %>
        <% if (players.size() > 2) { %>
        <div class="player third-place">
            <p>Player: <%= players.get(2).getName() %></p>
            <p>Score: <%= players.get(2).getScore() %></p>
            <p class="place">Place: 3rd</p>
        </div>
        <% } %>
        <% if (players.size() > 3) { %>
        <div class="player fourth-place">
            <p>Player: <%= players.get(3).getName() %></p>
            <p>Score: <%= players.get(3).getScore() %></p>
            <p class="place">Place: 4th</p>
        </div>
        <% } %>
    </div>
    <%
        }
    %>
    <form action="newGameServlet" method="post">
        <input class="button"  type="submit" value="Menu">
    </form>
</div>
</body>
</html>
