function longestStrChain(words: string[]): number {
  words.sort((a, b) => {
    return a.length < b.length ? -1 : 1;
  });

  const map = new Map<string, number>();
  let max = 1;
  for (let word of words) {
    for (let i = 0; i < word.length; i++) {
      let adjusted = getStringRemoveIndex(word, i);
      let length = (map.get(adjusted) ?? 0) + 1;
      max = Math.max(max, length);
      map.set(word, Math.max(map.get(word) ?? 1, length));
    }
  }

  return max;
};

function getStringRemoveIndex(text: string, index: number): string {
  let a = text.slice(0, index);
  let b = text.slice(index + 1);
  return a + b;
}