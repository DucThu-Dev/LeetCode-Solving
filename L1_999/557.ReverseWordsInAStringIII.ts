function reverseWords(s: string): string {
  const stack = new Array<string>();
  let result = ' ';
  for (let w of s) {
    if (w === '') {
      while (stack.length) {
        result += stack.pop()!;
      }
      result += w;
    } else {
      stack.push(w);
    }
  }

  while (stack.length) {
    result += stack.pop()!;
  }

  return result;
};