function findTheDifference(s: string, t: string): string {
  const sMap = new Array(26).fill(0);
  for (let c of s) {
    sMap[c.charCodeAt(0) - 97]++;
  }

  for (let c of t) {
    sMap[c.charCodeAt(0) - 97]--;
    if (sMap[c.charCodeAt(0) - 97] < 0) return c;
  }

  return 'a';
};