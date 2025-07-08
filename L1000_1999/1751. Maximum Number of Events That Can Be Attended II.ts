function maxValue(events: number[][], k: number): number {
  const n = events.length;
  let dp: number[][];

  dp = Array(k + 1);
  for (let i = 1; i <= k; i++) {
    dp[i] = new Array(n).fill(-1);
  }

  events.sort((a, b) => a[0] - b[0]);

  function dfs(curIndex: number, count: number): number {
    if (curIndex >= n || count === 0) return 0;
    if (dp[count][curIndex] !== -1) return dp[count][curIndex];

    dp[count][curIndex] = Math.max(
      dfs(curIndex + 1, count),
      dfs(bisectRight(events[curIndex][1]), count - 1) + events[curIndex][2]
    );

    return dp[count][curIndex];
  }

  function bisectRight(target: number): number {
    let left = 0;
    let right = events.length;
    while (left < right) {
      let middle = Math.floor(left + (right - left) / 2);
      if (events[middle][0] <= target) {
        left = middle + 1;
      } else {
        right = middle;
      }
    }

    return right;
  }

  return dfs(0, k);
}
