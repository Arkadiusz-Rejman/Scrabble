function dragStart(event) {
    console.log("dragStart: ", event.target.id);
    event.dataTransfer.setData("text/plain", event.target.id);
}

function allowDrop(event) {
    event.preventDefault();
    console.log("allowDrop: ", event.target);
}

function drop(event) {
    event.preventDefault();
    var tileId = event.dataTransfer.getData("text/plain");
    console.log("drop: tileId = ", tileId);
    var tile = document.getElementById(tileId);

    if (!tile) {
        console.error("Tile not found: ", tileId);
        return;
    }

    var target = event.target;
    console.log("drop: initial target = ", target);

    while (target && !target.classList.contains('cell') && target.id !== 'tile-container') {
        target = target.parentNode;
    }

    console.log("drop: final target = ", target);

    if (!target) {
        console.error("Drop target is invalid");
        target.style.cursor = "not-allowed";
        return;
    }

    if (tile.parentNode) {
        tile.parentNode.removeChild(tile);
    }

    target.appendChild(tile);
}

window.onload = function() {
    var timeLeft = 10;
    var timerElement = document.getElementById("timer");
    var playerElement = document.getElementById("player");

    function startTimer() {
        var timer = setInterval(function() {
            if (timeLeft <= 0) {
                clearInterval(timer);
                timeLeft = 10;

                var xhr = new XMLHttpRequest();

                xhr.onreadystatechange = function() {
                    if (xhr.readyState === XMLHttpRequest.DONE) {
                        if (xhr.status === 200) {
                            playerElement.innerHTML = xhr.responseText; // Aktualizuj div na odpowiedź z serwera
                        } else {
                            console.error('Nie udało się pobrać wartości gracza');
                        }
                    }
                };

                xhr.open("GET", "turnManagerServlet", true); // Ustawienie adresu URL servleta
                xhr.send();

                startTimer();
            } else {
                timerElement.innerHTML = timeLeft + " seconds left";
            }
            timeLeft -= 1;
        }, 1000);
    }

    startTimer();
}
