
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


function maxAncestorDiff(root: TreeNode | null): number {
  if (!root) return 0
  let ancestors: number[] = []
  let max = 0

  function traverse(node: TreeNode | null) {
    if (!node) return 0;
    for (let num of ancestors) {
      max = Math.max(max, Math.abs(num - node.val))
    }
    ancestors.push(node.val)
    traverse(node.left)
    traverse(node.right)
    ancestors.pop()
  }

  traverse(root)
  return max
};