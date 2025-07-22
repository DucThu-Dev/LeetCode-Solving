function maximumUniqueSubarray(nums: number[]): number {
  let set = new Set<number>();
  let left = 0;
  let sum = 0;
  let max = 0;

  for (let right = 0; right < nums.length; right++) {
    while (set.has(nums[right])) {
      set.delete(nums[left]);
      sum -= nums[left];
      left++;
    }

    sum += nums[right];
    set.add(nums[right]);
    max = Math.max(sum, max);
  }

  return max;
}
