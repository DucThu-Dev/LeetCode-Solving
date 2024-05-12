function largestLocal(grid: number[][]): number[][] {
  const gridSize = grid.length;
  const result: number[][] = new Array(gridSize - 2);
  for (let i = 0; i < gridSize - 2; i++) {
    result[i] = new Array(gridSize - 2)
  }
  for (let i = 1; i < gridSize - 1; i++) {
    for (let j = 1; j < gridSize - 1; j++) {
      result[i - 1][j - 1] = Math.max(
        grid[i - 1][j - 1],
        grid[i][j - 1],
        grid[i + 1][j - 1],
        grid[i + 1][j],
        grid[i + 1][j + 1],
        grid[i][j + 1],
        grid[i - 1][j + 1],
        grid[i - 1][j],
        grid[i][j],
      )
    }
  }
  return result;
};