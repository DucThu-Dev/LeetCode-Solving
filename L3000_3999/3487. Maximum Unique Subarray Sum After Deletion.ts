function maxSum(nums: number[]): number {
  let maxNegative: number | null = null;
  let set = new Set<number>();
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] < 0) {
      maxNegative = Math.max(nums[i], maxNegative ?? nums[i]);
    } else {
      if (!set.has(nums[i])) {
        set.add(nums[i]);
      }
    }
  }

  if (set.size > 0) {
    return Array.from(set.keys()).reduce((prev, curr) => prev + curr, 0);
  }
  return maxNegative;
}

function maxSum(nums: number[]): number {
  const positives = nums.filter((value) => value > 0);
  if (!positives.length) {
    return Math.max(...nums);
  } else {
    return Array.from(new Set(positives)).reduce((prev, cur) => prev + cur, 0);
  }
}
