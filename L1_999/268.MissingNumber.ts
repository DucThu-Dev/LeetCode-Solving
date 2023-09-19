function missingNumber(nums: number[]): number {
  let sum = 0;
  let total = 0;
  for (let num of nums) sum += num;
  for (let i = 0; i <= nums.length; i++)  total += i;
  return total - sum;
};

function missingNumberSet(nums: number[]): number {
  const set = new Set(nums);
  for (let i = 0; i <= nums.length; i++) {
    if (!set.has(i)) return i;
  }
  return -1;
};


function missingNumberLinear(nums: number[]): number {
  for (let i = 0; i < nums.length; i++) {
    if (nums.indexOf(i) < 0) return i;
  }
  return nums.length;
};