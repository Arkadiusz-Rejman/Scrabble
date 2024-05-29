function highlightTile(element) {
    document.querySelectorAll('.tile').forEach(tile => {
        tile.classList.remove('highlighted');
    });

    element.classList.add('highlighted');
}