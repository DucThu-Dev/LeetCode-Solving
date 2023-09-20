/// Cloned solution.
function minOperations(nums: number[], x: number): number {
  let target: number = -x;
  const n: number = nums.length;

  for (const num of nums) {
    target += num;
  }

  if (target === 0) {
    return n;
  }

  let maxLen: number = 0;
  let curSum: number = 0;
  let left: number = 0;

  for (let right: number = 0; right < n; ++right) {
    curSum += nums[right];

    while (left <= right && curSum > target) {
      curSum -= nums[left];
      left++;
    }

    if (curSum === target) {
      maxLen = Math.max(maxLen, right - left + 1);
    }
  }

  return maxLen ? n - maxLen : -1;
}


/// TLE
function minOperations2(nums: number[], x: number): number {
  if (!nums.length) return x === 0 ? 0 : -1;
  if (nums.length === 1) return x === nums[0] ? 1 : -1;
  if (nums[0] === x || nums[nums.length - 1] === x) return 1;

  let remLeft = new Map<number, number>();
  let remRight = new Map<number, number>();
  let n = 1;
  let length = nums.length;

  while (n <= nums.length) {
    for (let i = 0; i <= n; i++) {
      let left = i;
      let right = n - i;
      let leftSum = (remLeft.get(left - 1) ?? 0) + (left > 0 ? nums[left - 1] : 0);
      let rightSum = (remRight.get(right - 1) ?? 0) + (right > 0 ? nums[length - right] : 0);
      remLeft.set(left, leftSum);
      remRight.set(right, rightSum);
      if (leftSum + rightSum === x) return n;
    }
    n++;
  }
  return -1;
}

/// TLE
function minOperationsOriginal(nums: number[], x: number): number {

  let result = Math.min(check(nums, x, true), check(nums, x, false));
  if (result === Infinity) return -1;
  return result;

  function check(nums: number[], x: number, isLeft: boolean): number {
    if (!nums.length && !x) return 0;
    if (!nums.length && x) return Infinity;
    let num = nums.splice(isLeft ? 0 : nums.length - 1, 1);
    let remain = x - num[0];
    if (remain === 0) {
      nums.splice(isLeft ? 0 : nums.length, 0, num[0]);
      return 1;
    }
    if (remain < 0) {
      nums.splice(isLeft ? 0 : nums.length, 0, num[0]);
      return Infinity;
    }
    let result = 1 + Math.min(check(nums, remain, true), check(nums, remain, false))
    nums.splice(isLeft ? 0 : nums.length, 0, num[0]);
    return result;
  }
};