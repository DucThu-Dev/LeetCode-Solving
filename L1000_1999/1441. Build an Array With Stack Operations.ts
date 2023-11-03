function buildArray(target: number[], n: number): string[] {
  const operation: string[] = [];
  const PUSH = "Push", POP = "Pop";

  let targetPointer = 0;
  let targetLength = target.length;

  for (let i = 1; i <= n; i++) {
    if (i === target[targetPointer]) {
      operation.push(PUSH);
      targetPointer++;
      if (targetPointer >= targetLength) {
        return operation;
      }
    } else {
      operation.push(PUSH, POP);
    }
  }
  // Should never reach.
  return operation;
};