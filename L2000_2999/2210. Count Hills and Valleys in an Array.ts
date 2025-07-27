function countHillValley(nums: number[]): number {
  let count = 0;
  let lastIsUp: boolean | null = null;
  for (let i = 1; i < nums.length; i++) {
    let isUp: boolean | null =
      nums[i - 1] === nums[i] ? null : nums[i - 1] < nums[i];
    if (isUp != null) {
      if (lastIsUp == null) {
        lastIsUp = isUp;
      } else if (lastIsUp !== isUp) {
        count++;
        lastIsUp = isUp;
      }
    }
  }

  return count;
}
