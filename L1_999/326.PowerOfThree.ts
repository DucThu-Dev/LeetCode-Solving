function isPowerOfThree(n: number): boolean {
  if (n === 1) return true;
  if (n < 1) return false;
  return isPowerOfThree(n / 3);
};

function isPowerOfThreeMultiplyCheck(n: number): boolean {
  if (n < 0) return false;
  let rem = 1;
  while (rem < n) {
    rem *= 3;
  }
  return n === rem;
};

function isPowerOfThreeOriginal(n: number): boolean {
  while (n % 3 === 0 && n > 1) {
    n /= 3;
  }
  return n === 1;
};