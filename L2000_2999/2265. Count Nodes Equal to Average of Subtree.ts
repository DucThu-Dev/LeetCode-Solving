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

type Result = {
  nodeCount: number,
  sum: number
}

function averageOfSubtree(root: TreeNode | null): number {
  if (!root) return 0;
  let result = 0;

  traverse(root);

  function traverse(node: TreeNode | null | undefined): Result {
    if (!node) return {
      nodeCount: 0,
      sum: 0,
    };

    if (!node?.left && !node?.right) {
      result++;
      return {
        nodeCount: 1,
        sum: node?.val ?? 0,
      };
    }

    let resultLeft = traverse(node?.left);
    let resultRight = traverse(node?.right);
    let nodeCount = resultLeft.nodeCount + resultRight.nodeCount + 1;
    let sum = resultLeft.sum + resultRight.sum + 1;
    let avg = (sum) / (nodeCount) >> 0;
    if (node?.val === avg) result++;
    return {
      nodeCount: nodeCount,
      sum: sum,
    };
  }

  return result;
};