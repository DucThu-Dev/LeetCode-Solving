function sortArrayByParity(nums: number[]): number[] {
  let evens = new Array<number>(), odds = new Array<number>();
  for (let num of nums) {
    if (num % 2) {
      odds.push(num);
    } else {
      evens.push(num)
    }
  }
  return evens.concat(odds);
};