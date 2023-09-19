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

function isUglyCloned(n: number): boolean {
  if (n <= 0) return false;
  while (n % 2 === 0) {
    n /= 2;
  }
  while (n % 3 === 0) {
    n /= 3;
  }
  while (n % 5 === 0) {
    n /= 5;
  }

  return n === 1;
};