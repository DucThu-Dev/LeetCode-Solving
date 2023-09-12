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

/// Best solution
function minDeletionsCloned(s: string): number {
  const freq = new Array(26).fill(0);

  for (let i = 0; i < s.length; i++) {
    freq[s.charCodeAt(i) - 97]++;
  }

  const hash = new Map<number, number>();

  for (let f of freq) {
    updateMap(f, 1);
  }

  let count = 0;
  const hashLastSolve = new Map<number, number>();
  for (let key of hash.keys()) {
    while (hash.get(key)! > 1) {
      let search = key - 1;
      if (hashLastSolve.has(key)) {
        search = hashLastSolve.get(key)!;
      }
      while (hash.has(search) && hash.get(search)! > 0 && search > 0) {
        search--;
      }
      count += key - search;
      hashLastSolve.set(key, search);
      updateMap(search, 1);
      updateMap(key, -1);
    }
  }

  function updateMap(key: number, by: number) {
    if (key === 0) return;
    if (hash.has(key)) {
      hash.set(key, hash.get(key)! + by);
    } else {
      hash.set(key, 1);
    }
  }

  return count;
}