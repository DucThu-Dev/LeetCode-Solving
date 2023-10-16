function getRow(rowIndex: number): number[] {
  let triangle: Array<Array<number>> = [[1]];
  for (let i = 1; i <= rowIndex; i++) {
    let currentRow = [1];
    let parentTriangle = triangle[i - 1]
    for (let j = 1; j < i; j++) {
      currentRow[j] = parentTriangle[j] + parentTriangle[j - 1]
    }
    currentRow[i] = 1
    triangle[i] = currentRow
  }

  return triangle[rowIndex];
};