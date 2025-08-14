function largestGoodInteger(num: string): string {
  num += "n";
  let good: number | null = null;
  let lastN = "";
  let count = 0;
  for (let n of num) {
    if (n === lastN) {
      count++;
      if (count === 3) {
        good = Math.max(Number(lastN), good);
      }
    } else {
      lastN = n;
      count = 1;
    }
  }

  return good != null ? new Array(3).fill(good).join("") : "";
}
