// Dynamic programming
function combinationSum4(nums: number[], target: number): number {
  const hash: Map<number, number> = new Map<number, number>();
  return combineSum(nums, target, hash);
};

function combineSum(nums: number[], remain: number, hash: Map<number, number>): number {
  if (remain === 0) {
    return 1;
  }

  if (hash.has(remain)) return hash.get(remain)!;
  let count = 0;
  for (let i = 0; i < nums.length; i++) {
    if (remain - nums[i] >= 0) {
      count += combineSum(nums, remain - nums[i], hash);
    }
  }

  hash.set(remain, count);

  return count;
}