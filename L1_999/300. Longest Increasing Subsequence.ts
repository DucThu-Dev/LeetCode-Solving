function lengthOfLIS(nums: number[]): number {
  if (!nums.length) return 0;
  if (nums.length === 1) return 1;

  let maxOfThem = new Array<number>(nums.length);
  maxOfThem[0] = 1;

  for (let i = 1; i < nums.length; i++) {
    let maxOfThis = 1;
    for (let j = 0; j < i; j++) {
      if (nums[j] < nums[i]) {
        maxOfThis = Math.max(maxOfThis, maxOfThem[j] + 1)
      }
    }

    maxOfThem[i] = maxOfThis
  }

  return Math.max(...maxOfThem)
};