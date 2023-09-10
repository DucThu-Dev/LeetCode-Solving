// Cloned solution - Do not understand
function countOrders(n: number): number {
  let res: number = 1;
  const mod: number = 1000000007;
  for (let i = 1; i <= n; i++) {
    const m: number = i * 2 - 1;
    res = (res * (m * (m + 1) / 2)) % mod;
  }
  return res;
};