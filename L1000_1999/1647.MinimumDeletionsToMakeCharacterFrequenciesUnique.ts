function minDeletions(s: string): number {
  const hash = new Map<string, number>();
  let result = 0;
  for (let i = 0; i < s.length; i++) {
    if (!hash.has(s[i])) {
      hash.set(s[i], 1);
    } else {
      hash.set(s[i], hash.get(s[i])! + 1);
    }
  }

  const values: Array<number> = [...hash.values()];
  const set: Set<number> = new Set();
  const waitToProcess: number[] = [];
  for (let i = 0; i < values.length; i++) {
    let currentValue = values[i];
    if (!set.has(currentValue)) {
      set.add(currentValue);
    } else {
      waitToProcess.push(currentValue);
    }
  }

  for (let i = 0; i < waitToProcess.length; i++) {
    let currentValue = waitToProcess[i];
    while (currentValue > 0 && set.has(currentValue)) {
      currentValue--;
      result++;
    }
    if (currentValue !== 0) {
      set.add(currentValue);
    }
  }

  return result;
};