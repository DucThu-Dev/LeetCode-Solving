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

function removeLeafNodes(root: TreeNode | null, target: number): TreeNode | null {
  function traversal(node: TreeNode): boolean {
    if (node.left) {
      const shouldRemove = traversal(node.left)
      if (shouldRemove) {
        node.left = null
      }
    }

    if (node.right) {
      const shouldRemove = traversal(node.right)
      if (shouldRemove) {
        node.right = null
      }
    }

    return !node?.left && !node?.right && node?.val === target
  }

  const shouldRemove = traversal(root!)
  return shouldRemove ? null : root;
};