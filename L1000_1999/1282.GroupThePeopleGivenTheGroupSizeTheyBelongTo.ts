function groupThePeople(groupSizes: number[]): number[][] {
  const groupHash = new Map<number, Array<number>>();
  const result = new Array<Array<number>>();

  for (let i = 0; i < groupSizes.length; i++) {
    const groupSize = groupSizes[i];
    if (!groupHash.has(groupSize)) {
      groupHash.set(groupSize, []);
    }

    const group = groupHash.get(groupSize)!;
    group.push(i);
    if (group.length === groupSize) {
      result.push(group);
      groupHash.set(groupSize, []);
    }
  }

  return result;
};