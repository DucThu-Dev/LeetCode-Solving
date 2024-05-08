function findRelativeRanks(score: number[]): string[] {
  let map = new Map<number, string>()
  for (let i = 0; i < score.length; i++) {
    map.set(score[i], "")
  }

  score.sort((a, b) => b - a)
  for (let i = 0; i < score.length; i++) {
    let prize = ""
    if (i === 0) {
      prize = "Gold Medal"
    } else if (i === 1) {
      prize = "Silver Medal"
    } else if (i === 2) {
      prize = "Bronze Medal"
    } else {
      prize = `${i + 1}`
    }
    map.set(score[i], prize);
  }

  return Array.from(map.values())
};