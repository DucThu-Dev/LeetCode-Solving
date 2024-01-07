function numberOfArithmeticSlices(nums: number[]): number {
  const totalNums = nums.length;
  const dp: Array<Map<number, number>> = Array.from({ length: totalNums }, () => new Map())

  let result = 0
  for (let i = 1; i < totalNums; i++) {
    for (let j = 0; j < i; j++) {
      let diff = nums[i] - nums[j]
      if (dp[j].has(diff)) {
        dp[i].set(diff, dp[j].get(diff)! + (dp[i].get(diff) || 0))
        result += dp[j].get(diff)!
      }

      dp[i].set(diff, (dp[i].get(diff) || 0) + 1)
    }
  }

  return result
};

function numberOfArithmeticSlicesRepractice(nums: number[]): number {
  let totalNums = nums.length
  let dp: Array<Map<number, number>> = new Array(totalNums).fill(0).map(() => new Map())

  let result = 0
  for (let i = 1; i < totalNums; i++) {
    for (let j = 0; j < i; j++) {
      const diff = nums[i] - nums[j]
      if (dp[j].has(diff)) {
        dp[i].set(diff, dp[j].get(diff)! + (dp[i].get(diff) || 0))
        result += dp[j].get(diff)!
      }
      dp[i].set(diff, (dp[i].get(diff) || 0) + 1)
    }
  }

  return result
}