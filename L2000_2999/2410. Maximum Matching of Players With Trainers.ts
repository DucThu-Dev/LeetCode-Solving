function matchPlayersAndTrainers(
  players: number[],
  trainers: number[]
): number {
  players.sort((a, b) => a - b);
  trainers.sort((a, b) => a - b);

  const n = players.length;
  const m = trainers.length;
  let count = 0;

  for (let i = 0, j = 0; i < n && j < m; i++, j++) {
    while (j < m && players[i] > trainers[j]) {
      j++;
    }

    if (j < m) {
      count++;
    }
  }

  return count;
}
