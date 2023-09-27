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