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

function reverseWordsCloned(s: string): string {
  return s.split(' ').map((word) => {
    return word.split('').reverse().join('');
  }).join(' ');
}