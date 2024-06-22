
function highlightTile(tile) {
    var parentID = tile.parentNode.id;

    var parts = parentID.split("_");
    var firstPart = parseInt(parts[1], 10);

    if(firstPart >= 20){
        tile.classList.toggle('highlighted');
        var isDraggable = tile.getAttribute('draggable') === 'true';
        tile.setAttribute('draggable', isDraggable ? 'false' : 'true');
    }



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
        alert("already occupied")
        return;
    }

    let startCell = document.getElementById("cell_7_7");
    if (startCell && startCell.children.length === 0 && targetId !== "cell_7_7") {
        alert("First move - you have to start at the middle");
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
    var playerElement = document.getElementById("player");

    async function rednerDocks() {

        var xhr = new XMLHttpRequest();

        xhr.onreadystatechange = function () {
            if (xhr.readyState === XMLHttpRequest.DONE) {
                location.reload();
                if (xhr.status === 200) {
                    playerElement.innerHTML = xhr.responseText;

                } else {
                    console.error('Nie udało się pobrać wartości docków');
                }
            }
        };

        xhr.open("GET", "dockRednerServlet", true);
        xhr.send();
    }


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




