function findLucky(arr: number[]): number {
  const map = new Map<number, number>();
  for (let i = 0; i < arr.length; i++) {
    if (map.has(arr[i])) {
      map.set(arr[i], map.get(arr[i])! + 1);
    } else {
      map.set(arr[i], 1);
    }
  }

  let result = -1;
  map.forEach((value, key) => {
    if (value === key && value > result) {
      result = value;
    }
  });

  return result;
}
