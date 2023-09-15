// function minCostConnectPoints(points: number[][]): number {
//   const distanceMap = new Map<number[], Map<number[], number | null>>();
//   const sortedDistanceMap = ;

//   // Calculate distance between points
//   for (let point of points) {
//     let distanceValue = getDistanceValue(point);
//     for (let target of points) {
//       if (target !== point) {
//         if (!distanceValue.has(target)) {
//           let d = calculateManhattanDistance(point, target);
//           distanceValue.set(target, d);
//           getDistanceValue(target).set(point, d);
//         }
//       }
//     }
//   }

//   const connectMap = new Map<number[], number[][]>();
//   let cost = 0;
//   for (let [pointKey, targets] of distanceMap) {

//   }

//   function getDistanceValue(point: number[]): Map<number[], number | null> {
//     if (!distanceMap.has(point)) {
//       distanceMap.set(point, new Map<number[], number | null>());
//     }
//     return distanceMap.get(point)!;
//   }

//   function getConnectMapValue(point: number[]): number[][] {
//     if (!connectMap.has(point)) {
//       connectMap.set(point, []);
//     }
//     return connectMap.get(point)!;
//   }

//   return cost;
// };

// function calculateManhattanDistance(point1: number[], point2: number[]): number {
//   return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
// }

class UnionFind {
  root: number[];

  constructor(n: number) {
    this.root = Array.from({ length: n }, (_, i) => i);
  }

  find(v: number): number {
    if (this.root[v] === v) {
      return v;
    }
    return this.find(this.root[v]);
  }

  union(v1: number, v2: number): boolean {
    const ar1: number = this.find(v1);
    const ar2: number = this.find(v2);

    if (ar1 === ar2) {
      return false;
    }

    this.root[ar1] = ar2;
    return true;
  }
}

function minCostConnectPoints(points: number[][]): number {
  const n: number = points.length;
  const minHeap: number[][] = [];

  for (let i = 0; i < n; i++) {
    for (let j = i + 1; j < n; j++) {
      const mDist: number =
        Math.abs(points[i][0] - points[j][0]) +
        Math.abs(points[i][1] - points[j][1]);
      minHeap.push([i, j, mDist]);
    }
  }

  minHeap.sort((a, b) => a[2] - b[2]);

  const uf: UnionFind = new UnionFind(n + 1);
  let minCost: number = 0;
  let connectedEdge: number = 0;

  for (const node of minHeap) {
    if (uf.union(node[0], node[1])) {
      connectedEdge++;
      minCost += node[2];
    }
    if (connectedEdge === n - 1) {
      return minCost;
    }
  }

  return minCost;
}
