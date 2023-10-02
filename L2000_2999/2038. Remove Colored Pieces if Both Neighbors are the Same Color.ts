/// Original - TLE
function winnerOfGame(colors: string): boolean {
  let pointerA = 0;
  let pointerB = 0;

  let turnA = true;
  let currentPointer = pointerA;
  let currentColor = 'A';

  while (currentPointer < colors.length) {
    if (colors[currentPointer] === currentColor) {
      if (currentPointer + 2 >= colors.length) break;
      if (colors[currentPointer + 1] === currentColor &&
        colors[currentPointer + 2] === currentColor) {
        colors = colors.substring(0, currentPointer + 1) + colors.substring(currentPointer + 2);
        if (turnA) {
          pointerB = pointerB > pointerA ? pointerB - 1 : pointerB;
        } else {
          pointerA = pointerA > pointerB ? pointerA - 1 : pointerA;
        }
        turnA = !turnA;
        currentColor = turnA ? 'A' : 'B';
        currentPointer = turnA ? pointerA : pointerB;
        continue;
      }
    }
    currentPointer++;
  }

  return !turnA;
};

/// Self did.
function winnerOfGame2(colors: string): boolean {
  let moveA = 0;
  let moveB = 0;
  let lastWord = 'A';
  let rem = 0;
  for (let i = 0; i < colors.length; i++) {
    if (colors[i] === lastWord) {
      rem++;
    } else {
      if (rem > 2) { if (lastWord === 'A') moveA += rem - 2; else moveB += rem - 2; }
      lastWord = lastWord === 'A' ? 'B' : 'A';
      rem = 1;
    }
  }
  if (rem > 2) { if (lastWord === 'A') moveA += rem - 2; else moveB += rem - 2; }

  return moveA > moveB;
};

function winnerOfGameBestSolution(colors: string): boolean {
  let streakA = 0;
  let streakB = 0;
  let moveA = 0;
  let moveB = 0;

  for (let i = 0; i < colors.length; i++) {
    if (colors[i] === 'A') {
      streakA++;
      streakB = 0;
      if (streakA > 2) {
        moveA++;
      }
    } else {
      streakB++;
      streakA = 0;
      if (streakB > 2) {
        moveB++;
      }
    }
  }
  return moveA > moveB;
}