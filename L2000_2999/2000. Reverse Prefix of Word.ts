function reversePrefix(word: string, ch: string): string {
  const prefixReversed: string[] = []
  for (let i = 0; i < word.length; i++) {
    if (word[i] === ch) {
      prefixReversed.unshift(word[i])
      return prefixReversed.join('') + (i === word.length - 1 ? '' : word.substring(i + 1))
    } else {
      prefixReversed.unshift(word[i])
    }
  }
  return word
};

function reversePrefixBetter(word: string, ch: string): string {
  const targetIndex = word.indexOf(ch);

  return targetIndex === -1 ? word : word.substring(0, targetIndex + 1).split('').reverse().join('') + word.substring(targetIndex + 1)
};