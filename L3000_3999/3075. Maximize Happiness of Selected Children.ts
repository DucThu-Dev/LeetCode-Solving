function maximumHappinessSum(happiness: number[], k: number): number {
  happiness.sort((a, b) => b - a)
  let result = 0
  for (let i = 0; i < k; i++) {
    let h = happiness[i] - i;
    if (h > 0) {
      result += h
    } else {
      break;
    }
  }
  return result;
};