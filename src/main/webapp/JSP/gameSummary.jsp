
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="amk.scrabble.model.*" %>
<%@ page import="java.util.Comparator" %>
<%@ page import="java.util.stream.Collectors" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>gameSummary</title>
    <link rel="stylesheet" type="text/css" href="CSS/gameSummary.css">
</head>
<body>
    <div class = "container">
        <h1>PODSUMOWANIE GRY</h1>
        <% int i = 1; %>
        <% for(Player player : GameSession.get().getPlayers().stream().sorted(Comparator
            .comparingInt(Player::getScore).reversed()).collect(Collectors.toList())){ %>

            <p>Gracz: <%=player.getName()%></p>
            <p>Punkty: <%=player.getScore()%></p>
            <p>Miejsce: <%=i%></p>

        <%i++; %>

        <%}%>
        <p></p>

    </div>

</body>
</html>
