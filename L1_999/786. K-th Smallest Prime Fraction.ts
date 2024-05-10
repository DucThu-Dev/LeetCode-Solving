function kthSmallestPrimeFraction(arr: number[], k: number): number[] {
  const fractions: number[][] = []
  for (let i = 0; i < arr.length - 1; i++) {
    for (let j = 1; j < arr.length; j++) {
      fractions.push([arr[i], arr[j], arr[i] / arr[j]])
    }
  }

  fractions.sort((a, b) => a[2] - b[2])
  fractions[k - 1].pop()
  return fractions[k - 1]
};

function kthSmallestPrimeFractionCopied(arr: number[], k: number): number[] {
  let left = 0, right = 1;
  let res: number[] = [];

  while (left <= right) {
    let mid = left + (right - left) / 2;
    let j = 1, total = 0, num = 0, den = 0;
    let maxFrac = 0;
    const n = arr.length;
    for (let i = 0; i < n; i++) {
      while (j < n && arr[i] > arr[j] * mid) {
        j++;
      }
      total += n - j;
      if (j < n && maxFrac < arr[i] * 1.0 / arr[j]) {
        maxFrac = arr[i] * 1.0 / arr[j];
        num = i;
        den = j;
      }
    }
    if (total === k) {
      res = [arr[num], arr[den]];
      break;
    }
    if (total > k) {
      right = mid;
    } else {
      left = mid;
    }
  }
  return res;
};