function maxFreeTime(
  eventTime: number,
  k: number,
  startTime: number[],
  endTime: number[]
): number {
  let n = startTime.length,
    res = 0,
    t = 0;
  for (let i = 0; i < n; i++) {
    t += endTime[i] - startTime[i];
    let left = i <= k - 1 ? 0 : endTime[i - k];
    let right = i === n - 1 ? eventTime : startTime[i + 1];
    res = Math.max(res, right - left - t);
    if (i >= k - 1) {
      t -= endTime[i - k + 1] - startTime[i - k + 1];
    }
  }
  return res;
}
