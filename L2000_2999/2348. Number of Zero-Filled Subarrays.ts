function zeroFilledSubarray(nums: number[]): number {
  nums.push(-1);
  let zeroCount = 0;
  let total = 0;
  for (let num of nums) {
    if (num === 0) {
      zeroCount++;
    } else if (zeroCount > 0) {
      total += customCount(zeroCount);
      zeroCount = 0;
    }
  }
  return total;
}

function customCount(n: number): number {
  let sum = 0;
  for (let i = 0; i < n; i++) {
    sum += n - i;
  }
  return sum;
}
