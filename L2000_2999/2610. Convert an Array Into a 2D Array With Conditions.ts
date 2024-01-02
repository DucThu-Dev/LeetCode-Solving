function findMatrix(nums: number[]): number[][] {
  let result: Array<Array<number>> = []
  let current: Set<number> = new Set<number>();
  let allNums = nums
  let remain: Array<number> = []
  do {
    remain = [];
    for (let i = 0; i < allNums.length; i++) {
      let cur = allNums[i];
      if (!current.has(cur)) {
        current.add(cur);
      } else {
        remain.push(cur);
      }
    }
    result.push([...current])
    current = new Set();
    allNums = remain;
  } while (remain.length)

  return result;
};