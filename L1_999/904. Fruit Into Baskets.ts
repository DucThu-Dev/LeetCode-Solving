function totalFruit(fruits: number[]): number {
  const n = fruits.length;

  let map = new Map<number, number>();

  let right = 0;

  let max = Number.NEGATIVE_INFINITY;

  while (right < n) {
    const fruit = fruits[right];
    if (map.size < 2 || map.has(fruit)) {
      map.set(fruit, (map.get(fruit) ?? 0) + 1);
    } else {
      max = Math.max(
        max,
        Array.from(map.values()).reduce((prev, cur) => prev + cur, 0)
      );

      const leftFruit = fruits[right - 1];
      let left = right - 1;
      let leftCount = 0;
      while (left > 0 && fruits[left] === leftFruit) {
        leftCount++;
        left--;
      }
      map = new Map<number, number>();
      map.set(leftFruit, leftCount);
      map.set(fruits[right], 1);
    }

    right++;
  }

  max = Math.max(
    max,
    Array.from(map.values()).reduce((prev, cur) => prev + cur, 0)
  );

  return max;
}
