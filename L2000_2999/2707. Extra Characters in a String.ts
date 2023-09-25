function minExtraChar(s: string, dictionary: string[]): number {
  const dp = new Map<number, number>();
  let result = dfs(s, dictionary, dp);
  return result;
};

function dfs(text: string, dictionary: string[], dp: Map<number, number>): number {
  if (!text.length) {
    return 0;
  }

  if (dp.has(text.length)) {
    return dp.get(text.length)!;
  }

  let minimum = text.length;
  for (let word of dictionary) {
    if (text === word) {
      minimum = 0;
      dp.set(text.length, minimum)
      return minimum;
    } else if (text.startsWith(word)) {
      let result = dfs(text.substring(word.length), dictionary, dp);
      minimum = Math.min(minimum, result);
    }
  }

  let result = 1 + dfs(text.substring(1), dictionary, dp);
  minimum = Math.min(minimum, result);

  dp.set(text.length, minimum);
  return minimum;
}