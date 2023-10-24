function isPowerOfFour(n: number): boolean {
  if (n === 1) return true;
  if (n % 2 == 1) return false;
  while (n >= 4) {
      n /= 4
  }
  if (n === 1) return true;
  return false;
};