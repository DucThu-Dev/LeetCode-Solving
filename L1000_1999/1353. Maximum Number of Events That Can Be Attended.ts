function maxEvents(events: number[][]): number {
  const n = events.length;
  let maxDay = 0;
  for (const e of events) {
    maxDay = Math.max(maxDay, e[1]);
  }
  events.sort((a, b) => a[0] - b[0]);
  const pq = new MinPriorityQueue<number>();
  let ans = 0;
  for (let i = 1, j = 0; i <= maxDay; i++) {
    while (j < n && events[j][0] <= i) {
      pq.enqueue(events[j][1]);
      j++;
    }
    while (!pq.isEmpty() && pq.front() < i) {
      pq.dequeue();
    }
    if (!pq.isEmpty()) {
      pq.dequeue();
      ans++;
    }
  }
  return ans;
}

function maxEvents(events: number[][]): number {
  const n = events.length;
  let maxDay: number = 1;
  for (let i = 0; i < n; i++) {
    maxDay = Math.max(maxDay, events[i][1]);
  }

  events.sort((a, b) => a[0] - b[0]);

  const pq = new MinPriorityQueue<number>();
  let result = 0;
  for (let i = 0, day = 1; day <= maxDay; day++) {
    while (i < n && events[i][0] <= day) {
      pq.enqueue(events[i][1]);
      i++;
    }

    while (!pq.isEmpty() && pq.front() < day) {
      pq.dequeue();
    }

    if (!pq.isEmpty()) {
      pq.dequeue();
      result++;
    }
  }

  return result;
}
