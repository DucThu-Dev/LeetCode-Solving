class FindSumPairs {
  constructor(nums1: number[], nums2: number[]) {
    this.nums2 = nums2;
    this.freq1 = new Map();
    this.freq2 = new Map();
    for (const num of nums1) {
      this.freq1.set(num, (this.freq1.get(num) ?? 0) + 1);
    }
    for (const num of nums2) {
      this.freq2.set(num, (this.freq2.get(num) ?? 0) + 1);
    }
    this.keys = new Set(this.freq1.keys());
  }

  private nums2: number[];
  private freq1: Map<number, number>;
  private freq2: Map<number, number>;
  private keys: Set<number>;

  add(index: number, val: number): void {
    const target = this.nums2[index];
    this.freq2.set(target, (this.freq2.get(target) ?? 1) - 1);
    this.nums2[index] += val;
    this.freq2.set(
      this.nums2[index],
      (this.freq2.get(this.nums2[index]) ?? 0) + 1
    );
  }

  count(tot: number): number {
    let total = 0;
    for (const num of this.keys) {
      if (num > tot) continue;
      const sub = tot - num;
      total += (this.freq1.get(num) ?? 0) * (this.freq2.get(sub) ?? 0);
    }
    return total;
  }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * var obj = new FindSumPairs(nums1, nums2)
 * obj.add(index,val)
 * var param_2 = obj.count(tot)
 */
