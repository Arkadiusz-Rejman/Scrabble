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