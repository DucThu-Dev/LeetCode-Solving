function numOfUnplacedFruits(fruits: number[], baskets: number[]): number {
  const n = fruits.length;

  const occupied = new Array(n).fill(false);
  let basketStartIndex = 0;
  let count = 0;

  for (let i = 0; i < n; i++) {
    const fruit = fruits[i];
    let found = false;
    for (let j = basketStartIndex; j < n; j++) {
      if (occupied[j]) continue;
      const basket = baskets[j];
      if (fruit <= basket) {
        occupied[j] = true;
        found = true;
        if (basketStartIndex === j) {
          const next = findNextBasketStartIndex();
          if (next != null) {
            basketStartIndex = next;
          } else {
            return count;
          }
          break;
        }
      }
    }

    if (!found) count++;
  }

  function findNextBasketStartIndex(): number | null {
    for (let i = basketStartIndex + 1; i < n; i++) {
      if (!occupied[i]) {
        return i;
      }
    }

    return null;
  }

  return count;
}
