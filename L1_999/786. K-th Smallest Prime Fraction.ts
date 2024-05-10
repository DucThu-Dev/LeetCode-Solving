function kthSmallestPrimeFraction(arr: number[], k: number): number[] {
  const fractions: number[][] = []
  for (let i = 0; i < arr.length - 1; i++) {
    for (let j = 1; j < arr.length; j++) {
      fractions.push([arr[i], arr[j], arr[i] / arr[j]])
    }
  }

  fractions.sort((a, b) => a[2] - b[2])
  fractions[k - 1].pop()
  return fractions[k - 1]
};