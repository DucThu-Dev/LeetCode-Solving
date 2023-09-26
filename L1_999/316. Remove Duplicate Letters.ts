function removeDuplicateLettersPractice(s: string): string {
  let ans = '';
  const lastExist = new Array(26).fill(0);
  const answerExist = new Array(26).fill(false);

  function charIndex(char: string): number {
    return char.charCodeAt(0) - 97;
  }

  for (let i = 0; i < s.length; i++) {
    lastExist[charIndex(s[i])] = i;
  }

  for (let i = 0; i < s.length; i++) {
    if (answerExist[charIndex(s[i])]) continue;
    while (ans.length &&
      ans.charCodeAt(ans.length - 1) > s.charCodeAt(i) &&
      lastExist[charIndex(ans[ans.length - 1])] > i) {
      answerExist[charIndex(ans[ans.length - 1])] = false;
      ans = ans.slice(0, -1);
    }

    ans += s[i];
    answerExist[charIndex(s[i])] = true;
  }

  return ans;
}

function removeDuplicateLettersCloned(s: string): string {
  let ans = '';
  const lastPosition: number[] = new Array(26).fill(0);
  const check: boolean[] = new Array(26).fill(false);

  function calculate(char: string): number {
    return char.charCodeAt(0) - 'a'.charCodeAt(0);
  }

  for (let i = 0; i < s.length; i++) {
    lastPosition[calculate(s[i])] = i;
  }

  for (let i = 0; i < s.length; i++) {
    if (check[calculate(s[i])]) {
      continue;
    }

    while (ans.length > 0 &&
      ans.charAt(ans.length - 1) > s.charAt(i) &&
      lastPosition[calculate(ans.charAt(ans.length - 1))] > i) {
      check[calculate(ans.charAt(ans.length - 1))] = false;
      ans = ans.slice(0, -1)
    }

    ans += s.charAt(i);
    check[calculate(s[i])] = true;
  }
  return ans;
};