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

function evaluateTree(root: TreeNode | null): boolean {


  function traversal(node: TreeNode): boolean {
    if (node.val === 0) return false;
    if (node.val === 1) return true;
    if (node.val === 2) return traversal(node.left!) || traversal(node.right!);
    if (node.val === 3) return traversal(node.left!) && traversal(node.right!);
    throw new Error("Should not be reached");
  }

  return traversal(root!);
};