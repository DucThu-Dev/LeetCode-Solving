function sumSubarrayMins(arr: number[]): number {
  const n = arr.length
  if (n === 1) return arr.reduce((a, b) => a + b)
  const dp: Array<Array<number>> = [[]]

  let sum = 0;

  for (let i = 0; i < n; i++) {
    dp[0][i] = arr[i]
    sum += arr[i]
  }

  for (let i = 1; i < n; i++) {
    dp.push([])
    for (let j = 0; j < n - i; j++) {
      let nextMin = Math.min(dp[0][j], arr[i + j])
      dp[1].push(nextMin)
      sum += nextMin
    }
    dp.shift()
  }

  return modulo(sum);
};

function modulo(num: number): number {
  return num % 1000000007;
}