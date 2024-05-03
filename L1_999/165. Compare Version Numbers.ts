function compareVersion(version1: string, version2: string): number {
  const v1segs = version1.split(".").map((rev) => Number.parseInt(rev));
  const v2segs = version2.split(".").map((rev) => Number.parseInt(rev));

  let maxIndex = Math.max(v1segs.length, v2segs.length);
  for (let i = 0; i < maxIndex; i++) {
    const r1 = v1segs.length > i ? v1segs[i] : 0
    const r2 = v2segs.length > i ? v2segs[i] : 0
    if (r1 > r2) return 1;
    else if (r1 < r2) return -1;
  }
  return 0;
};