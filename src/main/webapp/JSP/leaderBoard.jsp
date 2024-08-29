<%--
  Created by IntelliJ IDEA.
  User: arkad
  Date: 29.08.2024
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Top 10 Scores - Scrabble</title>
    <link rel="stylesheet" type="text/css" href="CSS/leaderBoard.css">
</head>
<body>

<h1>Top 10 Scrabble Scores</h1>

<table>
    <tr>
        <th>Username</th>
        <th>Score</th>
    </tr>
    <%
        // Pobieranie wyników z bazy danych i wyświetlanie tabeli
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Połączenie z bazą danych (przykładowe, dostosuj do swojej konfiguracji)
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/leaderboard", "root", "java1234");
            statement = connection.createStatement();

            // Pobranie najlepszych 10 wyników
            String query = "SELECT * FROM score ORDER BY score DESC LIMIT 10";
            resultSet = statement.executeQuery(query);

            // Wyświetlenie wyników w tabeli
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                int score = resultSet.getInt("score");
    %>
    <tr>
        <td><%= username %></td>
        <td><%= score %></td>
    </tr>
    <%
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) try { resultSet.close(); } catch (SQLException e) {}
            if (statement != null) try { statement.close(); } catch (SQLException e) {}
            if (connection != null) try { connection.close(); } catch (SQLException e) {}
        }
    %>
</table>
<form action="newGameServlet" method="post">
    <input class="menu-button"  type="submit" value="Menu">
</form>
</body>
</html>
