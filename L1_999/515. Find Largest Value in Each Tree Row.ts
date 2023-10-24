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


function largestValues(root: TreeNode | null): number[] {
  if (!root) return [];
  const maxValues = [root.val];
  traversal(root, 1);

  function traversal(node: TreeNode, level: number) {
    if (!node.left && !node.right) return;
    let max = Math.max(node.left?.val ?? Number.MIN_SAFE_INTEGER, node.right?.val ?? Number.MIN_SAFE_INTEGER)
    if (level >= maxValues.length) {
      maxValues.push(max);
    } else {
      maxValues[level] = Math.max(maxValues[level], max)
    }

    if (node.left) {
      traversal(node.left, level + 1)
    }
    if (node.right) {
      traversal(node.right, level + 1)
    }
  }

  return maxValues;
};