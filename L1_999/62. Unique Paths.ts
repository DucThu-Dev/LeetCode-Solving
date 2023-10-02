/// TLE
function uniquePathsOriginal(m: number, n: number): number {
  return travel(0, 0);

  function travel(x: number, y: number): number {
    if (x >= m || y >= n) return 0;
    if (x === m - 1 && y === n - 1) return 1;

    let moveDown = travel(x, y + 1);
    let moveRight = travel(x + 1, y);

    return moveDown + moveRight;
  }
};