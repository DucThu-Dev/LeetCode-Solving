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

function leafSimilar(root1: TreeNode | null, root2: TreeNode | null): boolean {
  let output1 = getNodeOutput(root1)
  let output2 = getNodeOutput(root2)
  if (output1.length != output2.length) return false;
  for (let i = 0; i < output1.length; i++) {
    if (output1[i] !== output2[i]) return false;
  }
  return true;
};

function getNodeOutput(node: TreeNode | null): Array<number> {
  let result: Array<number> = [];
  if (!node) return result;

  if (!node?.left && !node?.right) {
    result = [node.val!];
  }

  if (node?.left) {
    result.push(...getNodeOutput(node.left))
  }
  if (node?.right) {
    result.push(...getNodeOutput(node.right))
  }

  return result;
}