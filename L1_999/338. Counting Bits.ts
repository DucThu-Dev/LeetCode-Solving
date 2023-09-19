function countBits(n: number): number[] {
  let result = new Array<number>(n + 1);
  for (let i = 0; i <= n; i++) {
    result[i] = i.toString(2).replace(/0/g, "").length;
  }
  return result;
};