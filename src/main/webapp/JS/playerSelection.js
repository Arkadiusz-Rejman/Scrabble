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