function kthGrammar(n: number, k: number): number {
  const rowValues = [0];
  function getkthGrammarParent(row: number, kth: number): number {
    if (row === 0) return rowValues[0];
    const parentKth = kth / 2 >> 0;
    const pkValue = getkthGrammarParent(row - 1, parentKth);
    rowValues.push((pkValue ? [1, 0] : [0, 1])[+(kth % 2)]);
    return rowValues[row];
  }

  return getkthGrammarParent(n - 1, k - 1);
};