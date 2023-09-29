function isMonotonic(nums: number[]): boolean {
  if (nums.length <= 2) return true;
  let incr: boolean | null = null;
  for (let i = 0; i < nums.length - 1; i++) {
    if (nums[i] === nums[i + 1]) continue;
    if (incr === null) {
      incr = nums[i] < nums[i + 1]
    } else {
      if (nums[i] < nums[i + 1] && !incr! || nums[i] > nums[i + 1] && incr!) return false;
    }
  }
  return true;
};