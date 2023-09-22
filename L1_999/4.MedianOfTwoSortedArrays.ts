function findMedianSortedArrays(nums1: number[], nums2: number[]): number {
  let p1: number = 0;
  let p2: number = 0;

  // Get the smaller value between nums1[p1] and nums2[p2] and move the pointer forwards.
  function getMin(): number {
    if (p1 < nums1.length && p2 < nums2.length) {
      return nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
    } else if (p1 < nums1.length) {
      return nums1[p1++];
    } else if (p2 < nums2.length) {
      return nums2[p2++];
    }
    return -1;
  }

  const m: number = nums1.length;
  const n: number = nums2.length;
  if ((m + n) % 2 === 0) {
    for (let i = 0; i < (m + n) / 2 - 1; ++i) {
      const tmp: number = getMin();
    }
    return (getMin() + getMin()) / 2;
  } else {
    for (let i = 0; i < (m + n) / 2; ++i) {
      const tmp: number = getMin();
    }
    return getMin();
  }
}