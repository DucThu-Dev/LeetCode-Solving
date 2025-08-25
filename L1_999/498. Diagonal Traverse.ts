function findDiagonalOrder(mat: number[][]): number[] {
  const n = mat[0].length;
  const m = mat.length;

  let goUp = true;
  let x = 0,
    y = 0;

  const output: number[] = [];

  while (x < n && y < m) {
    output.push(mat[y][x]);
    if (goUp) {
      if (y > 0 && x < n - 1) {
        x++;
        y--;
      } else {
        goUp = !goUp;
        if (x < n - 1) {
          x++;
        } else {
          y++;
        }
      }
    } else {
      if (x > 0 && y < m - 1) {
        x--;
        y++;
      } else {
        goUp = !goUp;
        if (y < m - 1) {
          y++;
        } else {
          x++;
        }
      }
    }
  }

  return output;
}
