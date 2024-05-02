function findMaxK(nums: number[]): number {
  if (nums.length <= 1) return -1;
  nums.sort((a, b) => a - b)

  while (nums.length) {
    if (nums[0] < 0 && nums[nums.length - 1] > 0) {
      if (Math.abs(nums[0]) === nums[nums.length - 1]) {
        return nums[nums.length - 1]
      } else if (Math.abs(nums[0]) > nums[nums.length - 1]) {
        nums.shift()
      } else {
        nums.pop()
      }
    }
    else {
      break;
    }
  }
  return -1;
};