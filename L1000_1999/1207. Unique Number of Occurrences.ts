function uniqueOccurrences(arr: number[]): boolean {
  const map = new Map<number, number>()
  for (let item of arr) {
    map.set(item, (map.get(item) || 0) + 1)
  }

  return new Set(map.values()).size === map.size
};