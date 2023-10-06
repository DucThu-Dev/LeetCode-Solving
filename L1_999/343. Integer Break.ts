function integerBreak1(n: number): number {
  if (n === 2) return 1
  if (n === 3) return 2

  const separated = new Map<number, number>([[2, 0], [3, 0]]);

  while (n > 0) {
    let remain = n % 3
    if (remain === 0) {
      separated.set(3, separated.get(3)! + 1);
      n -= 3;
    }
    if (remain === 1) {
      separated.set(2, separated.get(2)! + 1);
      n -= 2;
    }
    if (remain === 2) {
      if (n > 3) {
        separated.set(3, separated.get(3)! + 1);
        n -= 3;
      }
      else {
        separated.set(2, separated.get(2)! + 1);
        n -= 2;
      }
    }
  }

  return Math.pow(2, separated.get(2)!) * Math.pow(3, separated.get(3)!);
};

function integerBreak2(n: number): number {
  if (n === 2) return 1
  if (n === 3) return 2
  let countOf3 = n / 3 >> 0
  let remain = n % 3

  if (remain === 1) return Math.pow(3, countOf3 - 1) * 4
  if (remain === 2) return Math.pow(3, countOf3) * 2
  return Math.pow(3, countOf3);
}

/// Best solution
function integerBreak(n: number): number {
  const dp = new Array(n + 1).fill(0);

  for (let i = 2; i <= n; i++) {
      for (let j = 1; j < i; j++) {
          dp[i] = Math.max(dp[i], j * Math.max(i - j, dp[i - j]));
      }
  }

  return dp[n];
}