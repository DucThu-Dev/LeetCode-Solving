function kthCharacter(k: number, operations: number[]): string {
  let operationIndex = 0;
  const words = ["a"];
  while (words.length < k) {
    const opererate = operations[operationIndex];

    if (opererate === 0) {
      const length = words.length;
      for (let i = 0; i < length; i++) {
        words.push(words[i]);
      }
    } else {
      const length = words.length;
      for (let i = 0; i < length; i++) {
        words.push(
          words[i] === "z"
            ? "a"
            : String.fromCharCode(words[i].charCodeAt(0) + 1)
        );
      }
    }

    operationIndex++;
  }

  return words[k - 1];
}
