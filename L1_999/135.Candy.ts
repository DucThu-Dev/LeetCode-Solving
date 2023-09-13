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

function candyCloned(ratings: number[]): number {
  const candies = new Array(ratings.length).fill(1);
  const n = ratings.length;
  for (let i = 1; i < n; i++) {
    if (ratings[i] > ratings[i - 1]) {
      candies[i] = candies[i - 1] + 1;
    }
  }

  for (let i = n - 2; i >= 0; i--) {
    if (ratings[i] > ratings[i + 1]) {
      candies[i] = Math.max(candies[i], candies[i + 1] + 1);
    }
  }

  return candies.reduce((a, b) => a + b);
};
