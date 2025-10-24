console.log("ciao");
let redBox = document.querySelector(".redB");

redBox.addEventListener("mouseover", mouseInRed, false);
redBox.addEventListener("mouseout", mouseOutRed, false);

function mouseInRed() {
    redBox.style.backgroundColor = "rgb(254, 0, 2)";
    redBox.querySelectorAll("*").forEach(el => el.style.color = "white");
}

function mouseOutRed() {
    redBox.style.backgroundColor = "white";
    redBox.querySelectorAll("*").forEach(el => el.style.color = "rgb(254, 0, 2)");
}

let greenBox = document.querySelector(".greenB");
greenBox.addEventListener("mouseover", mouseInGreen, false);
greenBox.addEventListener("mouseout", mouseOutGreen, false);
function mouseInGreen() {
    greenBox.style.backgroundColor = "rgb(1, 165, 42)";
    greenBox.querySelectorAll("*").forEach(el => el.style.color = "white");

}
function mouseOutGreen() {
    greenBox.style.backgroundColor = "white";
    greenBox.querySelectorAll("*").forEach(el => el.style.color = "rgb(1, 165, 42)");
}

let blueBox = document.querySelector(".blueB");
blueBox.addEventListener("mouseover", mouseInBlue, false);
blueBox.addEventListener("mouseout", mouseOutBlue, false);
function mouseInBlue() {
    blueBox.style.backgroundColor = "rgb(0, 0, 126)";
    blueBox.querySelectorAll("*").forEach(el => el.style.color = "white");
}
function mouseOutBlue() {
    blueBox.style.backgroundColor = "white";
    blueBox.querySelectorAll("*").forEach(el => el.style.color = "rgb(0, 0, 126)");
}