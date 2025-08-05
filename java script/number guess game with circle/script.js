const buttonContainer = document.getElementById("buttonContainer");
const message = document.getElementById("message");
let attempts = 0;
const maxAttempts = 5;

const ids = [1, 4, 3, 2, 9, 7, 10, 8, 5, 6];

const secret = ids[Math.floor(Math.random() * ids.length)];
message.textContent = `Secret number (for testing): ${secret}`;


function handleClick(event) {
  const btn = event.target;
  const id = parseInt(btn.dataset.id);

  attempts++;

  if (id === secret) {
    btn.style.backgroundColor = "green";
    message.textContent = `Correct! You found the secret number ${secret} 🎉`;
    disableAllButtons();
  } else {
    btn.disabled = true;
    if (attempts >= maxAttempts) {
      message.textContent = `OOps you failed.`;
      disableAllButtons();
    } else {
      message.textContent = `Wrong guess! ${maxAttempts - attempts} attempt(s) left.`;
    }
  }
}

function disableAllButtons() {
  document.querySelectorAll(".circle-button").forEach(btn => btn.disabled = true);
}

ids.forEach(id => {
  const button = document.createElement("button");
  button.dataset.id = id;
  button.className = "circle-button";
  button.addEventListener("click", handleClick);
  buttonContainer.appendChild(button);
});
