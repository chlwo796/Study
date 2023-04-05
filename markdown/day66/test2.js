function checkFunc() {
  let number = document.getElementById("input").value;
  let text = document.getElementById("text");
  if (number == 1) {
    text.textContent = "Seoul";
  } else if (number == 2) {
    text.textContent = "Washington";
  } else if (number == 3) {
    text.textContent = "Tokyo";
  } else if (number == 4) {
    text.textContent = "Beijing";
  } else {
    text.textContent = "None";
  }
}
