function numIdenticalPairs(nums: number[]): number {
  const map = new Map<number, number>();
  const counted: number[] = [0];
  for (let i = 0; i < nums.length; i++) {
    if (!map.has(nums[i])) map.set(nums[i], 0);
    map.set(nums[i], map.get(nums[i])! + 1);
  }
  let result = 0;
  for (let [key, value] of map) {
    count(value);
    result += counted[value - 1];
  }
  return result;

  function count(target: number) {
    if (target > counted.length) return;
    for (let i = counted.length; i < target; i++) {
      counted.push(counted[counted.length - 1] + i);
    }
  }
};