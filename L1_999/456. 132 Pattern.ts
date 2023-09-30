function find132pattern(nums: number[]): boolean {
  for (let i1 = 0; i1 < nums.length - 2; i1++) {
    for (let i2 = i1 + 1; i2 < nums.length - 1; i2++) {
      if (nums[i2] > nums[i1]) {
        for (let i3 = i2 + 1; i3 < nums.length; i3++) {
          if (nums[i3] < nums[i2] && nums[i3] > nums[i1]) {
            return true;
          }
        }
      }
    }
  }
  return false;
};