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

function uniquePaths(m: number, n: number): number {
  const rem = new Map<number, Map<number, number>>();
  return travel(0, 0);

  function travel(x: number, y: number): number {
    if (x >= m || y >= n) return 0;
    if (x === m - 1 && y === n - 1) return 1;

    if (rem.has(m - x) && rem.get(m - x)!.has(n - y)) return rem.get(m - x)!.get(n - y)!;
    let result = 0;
    result += travel(x, y + 1);
    result += travel(x + 1, y);


    if (!rem.has(m - x)) {
      rem.set(m - x, new Map<number, number>())
    }
    rem.get(m - x)!.set(n - y, result);
    return result;
  }
};