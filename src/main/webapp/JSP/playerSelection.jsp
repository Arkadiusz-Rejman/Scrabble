<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Scrabble Game</title>
    <link rel="stylesheet" type="text/css" href="CSS/playerSelection.css">
    <script type="text/javascript" src="JS/playerSelection.js"></script>
</head>
<body>
        <form action="playerSelection" method="post">
            <label for="playerCount">Number of Players (1-4):</label>
            <input type="number" id="playerCount" name="playerCount" min="1" max="4" value="1" onchange="updatePlayerFields()">
            <div id="playerFields">
                <!-- Dynamic player fields will be added here -->
            </div>
            <button type="submit">Continue</button>
        </form>
        <script>
            // Initialize the player fields on page load
            updatePlayerFields();
        </script>
</body>
</html>
