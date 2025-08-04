function totalFruit(fruits: number[]): number {
  const n = fruits.length;

  let map = new Map<number, number>();

  let right = 0;

  let max = Number.NEGATIVE_INFINITY;

  let lastFruit = fruits[0];
  let lastCount = 0;

  while (right < n) {
    const fruit = fruits[right];
    let needReset = false;
    if (lastFruit === fruit) lastCount++;
    else needReset = true;

    if (map.size < 2 || map.has(fruit)) {
      map.set(fruit, (map.get(fruit) ?? 0) + 1);
    } else {
      max = Math.max(
        max,
        Array.from(map.values()).reduce((prev, cur) => prev + cur, 0)
      );

      map = new Map<number, number>();
      map.set(lastFruit, lastCount);
      map.set(fruits[right], 1);
    }

    if (needReset) {
      lastFruit = fruit;
      lastCount = 1;
    }

    right++;
  }

  max = Math.max(
    max,
    Array.from(map.values()).reduce((prev, cur) => prev + cur, 0)
  );

  return max;
}
