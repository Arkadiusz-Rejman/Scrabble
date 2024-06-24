
function highlightTile(tile) {
    // Pobieranie danych o tile
    var tileParts = tile.id.split("_");
    var firstTilePart = parseInt(tileParts[1], 10);
    var offset = Math.floor(firstTilePart / 10) * 10;

    // Sprawdzenie czy wszystkie kafelki znajduja sie w doku
    let allInDock = true;
    for (let i = 0; i <= 7; i++) {
        let tileId = `tile_${i + offset}`;
        let tileElem = document.getElementById(tileId);

        if (tileElem) {
            let parentIdParts = tileElem.parentNode.id.split("_");
            let parentFirstPart = parseInt(parentIdParts[1], 10);
            if (parentFirstPart < 20) {
                allInDock = false;
                break;
            }
        }
    }

    if (allInDock) {
        // jezeli wszystie są w doku to przelacz jego wyroznienie
        tile.classList.toggle('highlighted');

        // sprawdzenie czy którykolwiek jest wyrozniony
        var anyHighlighted = false;
        for (let i = 0; i <= 7; i++) {
            let tileId = `tile_${i + offset}`;
            let tileElem = document.getElementById(tileId);

            if (tileElem && tileElem.classList.contains('highlighted')) {
                anyHighlighted = true;
                break;
            }
        }

        // Ustaw atrybut draggable na true/false w zależności od tego, czy którykolwiek kafelek jest wyróżniony
        for (let i = 0; i <= 7; i++) {
            let tileId = `tile_${i + offset}`;
            let tileElem = document.getElementById(tileId);

            if (tileElem) {
                tileElem.setAttribute('draggable', anyHighlighted ? 'false' : 'true');
            }
        }
    }


    // Wysłanie danych do servleta
    var highlightedTileIds = findHighlightedTiles(offset);

    let sackDiv = document.getElementById('sackRepresentation');
    let h1Value = parseInt(sackDiv.querySelector('h1').textContent, 10);

    // Zabezpieczenie przeciw zaznaczaniem gdy nie ma tylu w worku
    if(highlightedTileIds.length > h1Value) {

        tile.classList.remove('highlighted');
        highlightedTileIds = findHighlightedTiles(offset);

    }



    if(highlightedTileIds.length > 0){

        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState === XMLHttpRequest.DONE) {
                if (xhr.status === 200) {
                    console.log('Success:', xhr.responseText);
                } else {
                    console.error('Failed to send highlightedItems');
                }
            }
        };

        xhr.open("POST", "changeTilesServlet", true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.send("tileIndex=" + encodeURIComponent(highlightedTileIds));

    }



}

function findHighlightedTiles(offset) {
    let highlightedTileIds = [];

    for (let i = 0; i <= 7; i++) {
        let tileId = `tile_${i + offset}`;
        let tileElem = document.getElementById(tileId);

        if (tileElem && tileElem.classList.contains('highlighted')){
            let adjustedTileId = `tile_${i}`;
            highlightedTileIds.push(adjustedTileId);
        }
    }

    return highlightedTileIds;
}

function dragStart(event) {
    console.log("dragStart: ", event.target.id);
    event.dataTransfer.setData("application/tile-id", event.target.id);
    event.dataTransfer.setData("application/tile-index", event.target.getAttribute("data-index"));
}

function allowDrop(event) {
    event.preventDefault();
    console.log("allowDrop: ", event.target);
}

function drop(event) {
    event.preventDefault();
    var tileId = event.dataTransfer.getData("application/tile-id");
    console.log("drop: tileId = ", tileId);
    var tile = document.getElementById(tileId);
    var tileIndex = event.dataTransfer.getData("application/tile-index");

    if (!tile) {
        console.error("Tile not found: ", tileId);
        return;
    }

    var target = event.target;
    var targetId = target.id;


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

    if (target.children.length > 0) {
        return;
    }

    let startCell = document.getElementById("cell_7_7");
    if (startCell && startCell.children.length === 0 && targetId !== "cell_7_7") {
        return;
    }

    if (tile.parentNode) {
        tile.parentNode.removeChild(tile);

    }


    target.appendChild(tile);


    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                console.log('Success:', xhr.responseText);
            } else {
                console.error('Failed to send tileIndex');
            }
        }
    };

    xhr.open("POST", "moveTileServlet", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send("tileIndex=" + encodeURIComponent(tileIndex) + "&targetID=" + encodeURIComponent(targetId));


}

//Timer tury dla gracza

window.onload = function () {

    var timeLeft = 180;
    var timerElement = document.getElementById("timer");


    //Średnio wiem jaki to miało cel, dlatego zakomentowałem
    // var playerElement = document.getElementById("player");
    //
    // async function rednerDocks() {
    //
    //     var xhr = new XMLHttpRequest();
    //
    //     xhr.onreadystatechange = function () {
    //         if (xhr.readyState === XMLHttpRequest.DONE) {
    //             location.reload();
    //             if (xhr.status === 200) {
    //                 playerElement.innerHTML = xhr.responseText;
    //
    //             } else {
    //                 console.error('Nie udało się pobrać wartości docków');
    //             }
    //         }
    //     };
    //
    //     xhr.open("GET", "dockRednerServlet", true);
    //     xhr.send();
    // }


    function startTimer() {
        var timer = setInterval(function () {
            if (timeLeft <= 0) {
                clearInterval(timer);
                timeLeft = 180;

                refreshPage();
                startTimer();

            } else {
                timerElement.innerHTML = timeLeft + " seconds left";
            }
            timeLeft -= 1;
        }, 1000);
    }

    startTimer();
}

function resign(){;
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            refreshPage();
            if (xhr.status === 200) {
                console.log('Success:', xhr.responseText);
            } else {
                console.error('Failed to open resignServletGET');
            }
        }
    };

    xhr.open("GET", "resignServlet", true);
    xhr.send();

}

async function refreshPage() {

    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            location.reload();
            if (xhr.status === 200) {
                playerElement.innerHTML = xhr.responseText;

            } else {
                console.error('Nie udało się pobrać wartości gracza');
            }
        }
    };

    xhr.open("GET", "turnManagerServlet", true);
    xhr.send();
}






