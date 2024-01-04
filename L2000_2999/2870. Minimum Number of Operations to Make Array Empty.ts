function minOperations(nums: number[]): number {
  if (nums.length <= 1) return -1
  nums.sort((a, b) => a - b);
  let result = 0;
  let count = 1;
  let cur = nums[0];
  try {
    for (let i = 1; i < nums.length; i++) {
      if (nums[i] === cur) {
        count++
        if (i === nums.length - 1) {
          doCheck();
        }
      }
      else {
        doCheck()
        cur = nums[i]
        count = 1
        if (i === nums.length - 1) throw "Count should at least 2";
        ;
      }
    }
  } catch (e) {
    return -1;
  }

  function doCheck() {
    /// count % 3 === 0 => /3
    /// count % 3 === 1 => 1, 4, 7 => (/3 - 1) + 2
    /// count % 3 === 2 => 2, 5, 8 => /3 + 1
    if (count === 1) throw "Count should at least 2";
    let sub = count % 3
    if (sub === 0) {
      result += count / 3 >> 0
    } else {
      result += (count / 3 >> 0) + 1
    }
  }

  return result;
};

function minOperationsBestSpeed(nums: number[]): number {
  const map = new Map<number, number>();
  nums.forEach((num) => {
    if (!map.has(num)) {
      map.set(num, 1)
    } else {
      map.set(num, map.get(num)! + 1)
    }
  });

  let result = 0;
  for (let [key, value] of map) {
    if (value == 1) return -1;
    if (value % 3 === 0) result += (value / 3 >> 0)
    else result += (value / 3 >> 0) + 1
  }
  return result;
}