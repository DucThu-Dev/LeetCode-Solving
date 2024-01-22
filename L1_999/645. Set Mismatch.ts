function findErrorNums(nums: number[]): number[] {
  const arr = new Array(nums.length).fill(0)
  const result: number[] = [];
  for (let num of nums) {
    if (arr[num - 1]) {
      result.push(arr[num - 1])
    } else {
      arr[num - 1] = num
    }
  }

  result.push(arr.indexOf(0) + 1)
  return result;
};