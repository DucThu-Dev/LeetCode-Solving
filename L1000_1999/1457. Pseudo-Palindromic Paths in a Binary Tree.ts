class TreeNode {
  val: number
  left: TreeNode | null
  right: TreeNode | null
  constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
    this.val = (val === undefined ? 0 : val)
    this.left = (left === undefined ? null : left)
    this.right = (right === undefined ? null : right)
  }
}


function pseudoPalindromicPaths(root: TreeNode | null): number {
  let result = 0;

  function traversal(node: TreeNode | null, track: number[]) {
    if (!node) return;
    track[node.val - 1]++;
    if (!node.left && !node.right) {
      if (isPalindromic(track)) result++
    } else {
      traversal(node.left, [...track])
      traversal(node.right, [...track])
    }
  }

  function isPalindromic(track: number[]): boolean {
    let oddCount = 0;
    for (let num of track) {
      if (num % 2 === 1) {
        oddCount++
        if (oddCount > 1) return false;
      }
    }
    return true;
  }

  traversal(root, new Array(9).fill(0))

  return result;
};