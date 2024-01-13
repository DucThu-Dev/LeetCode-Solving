function minSteps(s: string, t: string): number {
  let sCounters = new Array<number>(26).fill(0)
  let tCounters = new Array<number>(26).fill(0)
  for (let i = 0; i < s.length; i++) {
    let indexS = s.charCodeAt(i) - 97
    let indexT = t.charCodeAt(i) - 97
    sCounters[indexS]++
    tCounters[indexT]++
  }

  let diff = 0
  for (let i = 0; i < 26; i++) {
    diff += Math.abs(sCounters[i] - tCounters[i])
  }

  return diff / 2
};