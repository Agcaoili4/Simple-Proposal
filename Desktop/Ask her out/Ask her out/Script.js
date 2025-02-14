document.addEventListener("DOMContentLoaded", function () {
    const noButton = document.getElementById("noButton");
    const yesButton = document.getElementById("yesButton");

    // Load scream audio
    const screamSound = new Audio("pooping.mp3"); 

    if (yesButton) {
        yesButton.addEventListener("click", nextPage);
    }
    
    if (noButton) {
        noButton.addEventListener("mouseover", function () {
            screamSound.currentTime = 0; 
            screamSound.play();
            moveButton();
        });
    }
});

    
function nextPage() {
    window.location.href = "accept.html"; 
}

function moveButton() {
    const noButton = document.getElementById("noButton");
    if (!noButton) {
      return;
    }


    // Get window size and button size
    const maxX = window.innerWidth - noButton.offsetWidth - 20;
    const maxY = window.innerHeight - noButton.offsetHeight - 20;

    // Generate random positions within the viewport
    const randomX = Math.max(10, Math.random() * maxX);
    const randomY = Math.max(10, Math.random() * maxY);

    // Apply new position
    noButton.style.position = "absolute";
    noButton.style.left = `${randomX}px`;
    noButton.style.top = `${randomY}px`;
}
