function isUgly(n: number): boolean {
  if (n <= 0) return false;
  if (n == 1) return true;
  let uglys = [5, 3, 2];
  for (let u of uglys) {
    while (true) {
      if (n % u === 0) {
        let result = (n / u) >> 0
        if (result !== n) {
          n = result;
        } else {
          break;
        }
      } else {
        break;
      }
    }
  }

  if (Math.abs(n) >= 7) return false;
  return true;
};