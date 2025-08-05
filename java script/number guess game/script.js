
    const validNumbers = [1 , 2 , 3 , 4, 5, 6, 7, 8, 9, 10];
    const secret = validNumbers[Math.floor(Math.random() * validNumbers.length)];
    let chances = 3;

    function checkGuess() {
      const guess = parseInt(document.getElementById("guessInput").value);
      const messageDiv = document.getElementById("message");

      if (!validNumbers.includes(guess)) {
        messageDiv.innerHTML = `Please choose a valid number from ${validNumbers.join(", ")}`;
        return;
      }

      if (guess === secret) {
        messageDiv.innerHTML = `You guessed it right! The number was ${secret}.`;
        document.getElementById("guessInput").disabled = true;
        return;
      } else {
        chances--;
        messageDiv.innerHTML = `Wrong guess → ${guess}. Remaining chances: ${chances}`;
      }

      if (chances === 0 || chances < 0) {
        messageDiv.innerHTML += `<br> You lost! The correct number was ${secret}.`;
        document.getElementById("guessInput").disabled = true;
      }
    }
 