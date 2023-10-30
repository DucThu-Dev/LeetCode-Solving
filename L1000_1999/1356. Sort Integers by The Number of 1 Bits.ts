function sortByBits(arr: number[]): number[] {
  const map = new Map<number, Array<number>>();

  for (let i = 0; i < arr.length; i++) {
    const totalBit1 = countSetBits(arr[i]);
    getMapValue(totalBit1).push(arr[i]);
  }

  function getMapValue(key) {
    if (!map.has(key)) {
      map.set(key, []);
    }
    return map.get(key)!
  }

  const sortedKey = Array.from(map.keys()).sort((a, b) => a - b);
  let result: number[] = [];
  for (let i = 0; i < sortedKey.length; i++) {
    result = [...result, ...getMapValue(sortedKey[i]).sort((a, b) => a - b)];
  }
  return result;
};

function countSetBits(n: number): number {
  let count = 0;
  while (n) {
    n &= n - 1;
    count++;
  }
  return count;
}
