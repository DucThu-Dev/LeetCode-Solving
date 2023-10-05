function majorityElement(nums: number[]): number[] {
  let targetExist = (nums.length / 3 >> 0) + 1
  let remMap = new Map<number, number>()
  let result = new Array<number>()

  for (let i = 0; i < nums.length; i++) {
    remMap.set(nums[i], (remMap.get(nums[i]) ?? 0) + 1)
    if (remMap.get(nums[i]) === targetExist) {
      result.push(nums[i])
    }
  }

  return result
};