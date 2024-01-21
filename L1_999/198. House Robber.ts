function rob(nums: number[]): number {
  const n = nums.length
  let dp: number[] = new Array(n).fill(-1)

  function traversal(house: number): number {
    if (house >= n) return 0;
    if (dp[house] !== -1) return dp[house];

    let travel2 = traversal(house + 2)
    let travel3 = traversal(house + 3)

    let max = Math.max(travel2, travel3) + nums[house]
    dp[house] = max;
    return max;
  }

  return Math.max(traversal(0), traversal(1));
};