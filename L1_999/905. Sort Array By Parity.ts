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

function sortArrayByParityBestSolution(nums: number[]): number[] {
  let i = 0;
  for (let j = 0; j < nums.length; j++) {
    if (nums[j] % 2 === 0) {
      let temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
      i++;
    }
  }

  return nums;
}