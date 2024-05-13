function matrixScore(grid: number[][]): number {
  let row = grid.length;
  let column = grid[0].length;
  let result = 0;

  for (let i = 0; i < row; i++) {
    const current = grid[i]
    if (current[0] === 0) {
      for (let j = 0; j < column; j++) {
        current[j] = 1 - current[j];
      }
    }
  }

  const effective1 = (row / 2 >> 0) + +(row % 2 > 0)
  for (let j = 0; j < column; j++) {
    let count1 = 0;
    for (let i = 0; i < row; i++) {
      count1 += grid[i][j];
    }
    if (count1 < effective1) {
      for (let i = 0; i < row; i++) {
        grid[i][j] = 1 - grid[i][j];
      }
    }
  }

  for (let i = 0; i < row; i++) {
    for (let j = 0; j < column; j++) {
      result += Math.pow(2, column - j - 1) * grid[i][j]
    }
  }

  return result;
};