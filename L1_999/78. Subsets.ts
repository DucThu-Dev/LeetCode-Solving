function subsets(nums: number[]): number[][] {
  const result: number[][] = []
  function backtrack(curr: number[], idx: number) {
    result.push([...curr])
    for (let i = idx; i < nums.length; i++) {
      curr.push(nums[i])
      backtrack(curr, idx + 1)
      curr.pop()
      idx++;
    }
  }

  backtrack([], 0);
  return result
}