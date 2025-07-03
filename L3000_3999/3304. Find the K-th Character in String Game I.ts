function kthCharacter(k: number): string {
  let word = "a";

  while (word.length < k) {
    let nextChunk = "";
    for (let i = 0; i < word.length; i++) {
      let nextCode = word.charCodeAt(i) + 1;
      /// Char code z + 1.
      if (nextCode >= 123) {
        /// Char code a
        nextCode = 97;
      }
      nextChunk = `${nextChunk}${String.fromCharCode(nextCode)}`;
    }

    word = `${word}${nextChunk}`;
  }

  return word[k - 1];
}
