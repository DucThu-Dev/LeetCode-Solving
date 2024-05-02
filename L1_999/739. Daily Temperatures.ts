function dailyTemperatures(temperatures: number[]): number[] {
  /// Item is [index, value, count]
  const checking: number[][] = []
  const n = temperatures.length
  const result: number[] = new Array(n).fill(0)

  for (let i = 0; i < n; i++) {
    let value = temperatures[i];
    for (let j = 0; j < checking.length;) {
      let group = checking[j];
      if (group[1] < value) {
        result[group[0]] = group[2] + 1;
        checking.splice(j, 1)
      } else {
        group[2]++
        j++
      }

    }
    checking.push([i, value, 0])
  }

  return result;
};