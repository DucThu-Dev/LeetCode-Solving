function candy(ratings: number[]): number {
  const candies = new Array(ratings.length).fill(1);
  let didAdjust = true;
  while (didAdjust) {
    didAdjust = false;
    for (let i = 0; i < ratings.length - 1; i++) {
      if (ratings[i] > ratings[i + 1]) {
        if (candies[i] <= candies[i + 1]) {
          candies[i]++;
          didAdjust = true;
        }
      } else if (ratings[i] < ratings[i + 1]) {
        if (candies[i] >= candies[i + 1]) {
          candies[i + 1]++;
          didAdjust = true;
        }
      }
    }
  }

  return candies.reduce((a, b) => a + b);
};