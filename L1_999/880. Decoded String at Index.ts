function decodeAtIndex(s: string, k: number): string {
  let currentLength = 0;
  let currentIndex = 0;
  while (currentIndex < k) {
    if (/\d/.test(s[currentIndex])) {
      currentLength *= parseInt(s[currentIndex]);
    } else {
      currentLength++;
    }
    currentIndex++;
  }

  for (let i = currentIndex - 1; i >= 0; i--) {
    if (/\d/.test(s[i])) {
      currentLength /= parseInt(s[i])
      k %= currentLength;
    } else {
      if (k === currentLength || k === 0) {
        return s[i];
      }

      currentLength--;
    }
  }
  return '';
}

// Out of memory
function decodeAtIndexOriginal(s: string, k: number): string {
  let tape = '';
  let indexChar = 0;
  while (s.length && tape.length < k) {
    let char = s[indexChar];
    if (isDigit(char)) {
      let digit = parseInt(char);
      let newTape = '';
      for (let i = 0; i < digit; i++) {
        newTape += tape;
      }

      tape = newTape;
    } else {
      tape += char;
    }
    indexChar++;
  }

  return tape[k];
};

function isCharacter(char: string): boolean {
  return /^[a-z]$/.test(char);
}

function isDigit(char: string): boolean {
  return /^[0-9]$/.test(char);
}