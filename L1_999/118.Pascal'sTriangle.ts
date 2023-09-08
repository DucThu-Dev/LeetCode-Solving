function generate(numRows: number): number[][] {
  const result: number[][] = [];
  for (let iRow = 0; iRow < numRows; iRow++) {
    let currentRow: number[] = [];
    let parentRow: number[] = [];
    if (iRow != 0) parentRow = result[iRow - 1];
    for (let iItem = 0; iItem < iRow + 1; iItem++) {
      if (iItem == 0 || iItem == iRow) {
        currentRow.push(1);
      } else {
        currentRow.push(parentRow[iItem - 1] + parentRow[iItem]);
      }
    }
    result.push(currentRow);
  }

  return result;
};