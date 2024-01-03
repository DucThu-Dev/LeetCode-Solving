function findContentChildren(g: number[], s: number[]): number {
  let gIndex = 0, sIndex = 0;
  let result = 0
  g.sort((a, b) => a - b)
  s.sort((a, b) => a - b)
  while (gIndex < g.length && sIndex < s.length) {
    if (g[gIndex] <= s[sIndex]) {
      result++
      gIndex++
      sIndex++
    } else {
      sIndex++
    }
  }
  return result;
};

function findContentChildrenBestSpeed(g: number[], s: number[]): number {
  let result = 0
  g.sort((a, b) => a - b)
  s.sort((a, b) => a - b)
  for (let gIndex = 0, sIndex = 0; gIndex < g.length && sIndex < s.length; sIndex++) {
    if (g[gIndex] <= s[sIndex]) {
      gIndex++;
      result++;
    }
  }

  return result;
};
