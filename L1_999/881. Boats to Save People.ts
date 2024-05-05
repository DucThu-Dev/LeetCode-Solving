function numRescueBoats(people: number[], limit: number): number {
  people.sort((a, b) => a - b)
  let i = 0, j = people.length - 1;
  let min = 0;
  while (i <= j) {
    if (i === j) {
      min++;
      i++;
      break;
    }
    if (people[i] + people[j] <= limit) {
      min++;
      i++;
      j--;
    } else {
      min++;
      j--;
    }
  }
  return min;
};