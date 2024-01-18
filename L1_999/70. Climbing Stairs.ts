function climbStairs(n: number): number {
  if (n === 1) return 1;
  let map = new Map<number, number>()

  function traversal(step: number): number {
    if (step === 1 || step === 0) return 1;

    if (!map.has(step)) {
      let step1 = traversal(step - 1)
      let step2 = traversal(step - 2)

      map.set(step, step1 + step2)
      return step1 + step2
    } else {
      return map.get(step)!
    }
  }

  return traversal(n);
};