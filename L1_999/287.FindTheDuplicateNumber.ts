function findDuplicate(nums: number[]): number {
  let slow = 0;
  let fast = 0;
  while (true) {
    slow = nums[slow];
    fast = nums[nums[fast]];
    if (slow === fast) break;
  }

  let beginCycle = 0;
  while (true) {
    slow = nums[slow];
    beginCycle = nums[beginCycle];
    if (slow === beginCycle) return slow;
  }
}

function findDuplicateCloned(nums: number[]): number {
  let slow = 0;
  let fast = 0;

  while (true) {
    slow = nums[slow];
    fast = nums[nums[fast]];

    if (slow === fast) {
      break;
    }
  }

  let beginCycle = 0;

  while (true) {
    slow = nums[slow];
    beginCycle = nums[beginCycle];

    if (beginCycle === slow) {
      return beginCycle;
    }
  }
}