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

function getRowRecursive(rowIndex: number): number[] {
  if (rowIndex === 0) return [1]

  const lastRow = getRow(rowIndex - 1);
  return Array(rowIndex + 1).fill(1).map((value, index) => {
    if (index === 0 || index === rowIndex) return 1;
    return lastRow[index - 1] + lastRow[index];
  });
}