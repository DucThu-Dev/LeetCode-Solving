function find132patternOriginal(nums: number[]): boolean {
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

/// Checking solution here.
/// https://leetcode.com/problems/132-pattern/solutions/4107421/99-35-stack-left-approach-binary-search/

/// Stack based.
/// Example: [1,2,3,4], [3,1,4,2]
function find132pattern(nums: number[]): boolean {
  const stack = new Array<number>();
  let third = -Infinity;

  for (let i = nums.length - 1; i >= 0; i--) {
    if (nums[i] < third) return true;
    while (stack.length > 0 && stack[stack.length - 1] < nums[i]) {
      third = stack.pop()!;
    }
    stack.push(nums[i]);
  }
  return false;
}