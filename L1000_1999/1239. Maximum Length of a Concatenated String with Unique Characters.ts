function maxLength(arr: string[]): number {
  const n = arr.length;
  if (n === 1) return validWord(arr[0]) ? arr[0].length : 0
  let max = 0;

  for (let i = 0; i < n; i++) {
    if (validWord(arr[i])) {
      max = Math.max(max, arr[i].length)
      backTracking(arr[i], i + 1)
    }
  }

  return max;

  function backTracking(current: string, index: number) {
    for (let i = index; i < n; i++) {
      if (!isValid(current, arr[i])) continue;
      let next = current + arr[i];
      max = Math.max(next.length, max)
      backTracking(next, i + 1)
    }
  }

  function isValid(current: string, next: string) {
    if (!validWord(next)) return false;
    for (let c of current) {
      for (let d of next) {
        if (c === d) return false;
      }
    }
    return true;
  }

  function validWord(word: string) {
    let set = new Set<string>();
    for (let i = 0; i < word.length; i++) {
      if (set.has(word[i])) return false;
      set.add(word[i])
    }
    return true;
  }
};