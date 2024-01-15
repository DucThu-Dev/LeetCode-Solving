function findWinners(matches: number[][]): number[][] {
  const map = new Map<number, number>()
  const n = matches.length
  for (let i = 0; i < n; i++) {
    let match = matches[i]
    let player1 = match[0]
    let player2 = match[1]
    if (!map.has(player1)) {
      map.set(player1, 0)
    }
    if (!map.has(player2)) {
      map.set(player2, 1)
    } else {
      map.set(player2, map.get(player2)! + 1)
    }
  }

  const lose0: number[] = []
  const lose1: number[] = []

  for (let [key, value] of map) {
    if (value === 0) lose0.push(key)
    else if (value === 1) lose1.push(key)
  }

  lose0.sort((a, b) => a - b)
  lose1.sort((a, b) => a - b)

  return [lose0, lose1]
};