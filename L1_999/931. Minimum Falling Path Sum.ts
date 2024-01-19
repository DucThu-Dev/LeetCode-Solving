function minFallingPathSum(matrix: number[][]): number {
  const n = matrix.length
  if (n === 0) return 0
  if (n === 1) return matrix[0][0]
  const dp = new Map<number, Map<number, number>>()

  for (let i = 0; i < n; ++i) {
    dp.set(i, new Map<number, number>())
  }

  const lastLine = dp.get(n - 1)!
  const lastLineData = matrix[n - 1]
  for (let i = 0; i < n; ++i) {
    lastLine.set(i, lastLineData[i])
  }

  for (let i = n - 2; i >= 0; --i) {
    let line: Map<number, number> = dp.get(i)!
    let bottomLine: Map<number, number> = dp.get(i + 1)!

    for (let j = 0; j < n; ++j) {
      let min = Number.POSITIVE_INFINITY
      if (j === 0) {
        min = Math.min(bottomLine.get(j)!, bottomLine.get(j + 1)!)
      } else if (j === n - 1) {
        min = Math.min(bottomLine.get(j)!, bottomLine.get(j - 1)!)
      } else {
        min = Math.min(bottomLine.get(j)!, Math.min(bottomLine.get(j - 1)!, bottomLine.get(j + 1)!))
      }

      line.set(j, min + matrix[i][j])
    }
  }

  return new Array(...dp.get(0)!.values()).sort((a, b) => a - b)[0]
};


function minFallingPathSumBest(matrix: number[][]): number {
  const n = matrix.length;
  for (let i = 1; i < n; ++i) {
    for (let j = 0; j < n; ++j) {
      let add = matrix[i][j]

      let min = Number.POSITIVE_INFINITY
      if (j === 0) {
        min = Math.min(matrix[i - 1][j], matrix[i - 1][j + 1])
      } else if (j === n - 1) {
        min = Math.min(matrix[i - 1][j], matrix[i - 1][j - 1])
      } else {
        min = Math.min(matrix[i - 1][j], Math.min(matrix[i - 1][j - 1], matrix[i - 1][j + 1]))
      }

      matrix[i][j] = min + add
    }
  }

  return Math.min(...matrix[n - 1])
}