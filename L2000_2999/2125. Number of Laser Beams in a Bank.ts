function numberOfBeams(bank: string[]): number {
  if (!bank.length) return 0;
  let result = 0;
  let row = 0;
  let currentRowCount = getNextRowCount();
  if (!currentRowCount) return 0;
  while (row < bank.length) {
    let nextRowCount = getNextRowCount();
    if (nextRowCount) {
      result += nextRowCount * currentRowCount
      currentRowCount = nextRowCount
    }
  }

  function getNextRowCount(): number | null {
    if (row >= bank.length) return null;
    let cur = bank[row]
    let count = 0;
    for (let i = 0; i < cur.length; i++) {
      if (cur[i] === '1') {
        count++;
      }
    }
    row++;
    if (count === 0) {
      return getNextRowCount();
    } else {
      return count;
    }
  }

  return result;
};