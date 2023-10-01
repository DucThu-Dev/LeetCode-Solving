function reverseWords(s: string): string {
  let rem = '';
  let result = '';
  for (let w of s) {
    if (w === ' ') {
      result += rem;
      rem = '';
      result += w;
    } else {
      rem = w + rem;
    }
  }

  result += rem;
  return result;
};