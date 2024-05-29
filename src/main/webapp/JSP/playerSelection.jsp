<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Scrabble Game</title>
    <link rel="stylesheet" type="text/css" href="CSS/playerSelection.css">

        <script>
            function updatePlayerFields() {
                var playerCount = document.getElementById("playerCount").value;
                var playerFields = document.getElementById("playerFields");
                playerFields.innerHTML = "";

                 var colors = ["#add8e6", "#90ee90", "#ffb6c1", "#ffff99"];

                for (var i = 1; i <= playerCount; i++) {
                    var fieldSet = document.createElement("fieldset");
                    var legend = document.createElement("legend");
                    legend.textContent = "Player " + i;
                    fieldSet.appendChild(legend);

                    var label = document.createElement("label");
                    label.setAttribute("for", "player" + i);
                    label.textContent = "Name: ";
                    fieldSet.appendChild(label);

                    var input = document.createElement("input");
                    input.setAttribute("type", "text");
                    input.setAttribute("id", "player" + i);
                    input.setAttribute("name", "player" + i);
                    fieldSet.appendChild(input);



                    fieldSet.style.backgroundColor = colors[(i - 1) % colors.length];

                    playerFields.appendChild(fieldSet);
                }
            }
        </script>

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
