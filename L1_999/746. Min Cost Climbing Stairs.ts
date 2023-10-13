function minCostClimbingStairs(cost: number[]): number {
  const n = cost.length
  const effectiveCost = new Array<number>(cost.length);
  effectiveCost[0] = cost[0]
  effectiveCost[1] = cost[1]

  for (let i = 2; i < n; i++) {
    effectiveCost[i] = Math.min(effectiveCost[i - 1], effectiveCost[i - 2]) + cost[i]
  }

  return Math.min(effectiveCost[n - 1], effectiveCost[n - 2]);
};