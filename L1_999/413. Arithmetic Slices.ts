function numberOfArithmeticSlices(nums: number[]): number {
  let dp = new Array<number>(nums.length).fill(0);
  for (let i = 2; i < nums.length; i++) {
    if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
      dp[i] = dp[i - 1] + 1;
    }
  }

  return dp.reduce((last, current) => last + current)
};

function numberOfArithmeticSlicesBestSolution(nums: number[]): number {
  let curr = 0
  let sum = 0
  for (let i = 2; i < nums.length; i++) {
    if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
      sum++
      curr += sum
    } else {
      sum = 0
    }
  }
  return curr;
}