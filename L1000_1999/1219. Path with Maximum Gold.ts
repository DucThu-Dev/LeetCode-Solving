function getMaximumGold(grid: number[][]): number {
  const row = grid.length;
  const column = grid[0].length;
  let maxResult = 0;

  for (let i = 0; i < row; i++) {
    for (let j = 0; j < column; j++) {
      maxResult = Math.max(dfs(i, j), maxResult);
    }
  }

  function dfs(i: number, j: number): number {
    if (grid[i][j] === 0) return 0
    let top = 0, right = 0, bottom = 0, left = 0
    const cellValue = grid[i][j];
    grid[i][j] = 0;
    if (i > 0) {
      top = dfs(i - 1, j)
    }
    if (j < column - 1) {
      right = dfs(i, j + 1)
    }
    if (i < row - 1) {
      bottom = dfs(i + 1, j)
    }
    if (j > 0) {
      left = dfs(i, j - 1);
    }
    grid[i][j] = cellValue;
    return cellValue + Math.max(top, right, bottom, left)
  }

  return maxResult;
};