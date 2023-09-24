function champagneTower(poured: number, query_row: number, query_glass: number): number {
  const pouredMem: number[][] = new Array(query_row + 2).fill(null)
    .map((_, index) => new Array(index + 1).fill(0));

  pouredMem[0][0] = poured;

  for (let i = 0; i < query_row + 1; i++) {
    for (let y = 0; y <= i; y++) {
      if (pouredMem[i][y] > 1) {
        let excess = pouredMem[i][y] - 1;
        pouredMem[i + 1][y] += excess / 2;
        pouredMem[i + 1][y + 1] += excess / 2;
      }
    }
  }

  return pouredMem[query_row][query_glass] < 1 ? pouredMem[query_row][query_glass] : 1;
};