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

function findMode(root: TreeNode | null): number[] {
  if (!root) return [];

  let result: number[] = [];
  let max = 1;
  let rem: Map<number, number> = new Map();
  travel(root);

  function addCountKey(key: number): number {
    if (!rem.has(key)) {
      rem.set(key, 1);
      return 1;
    } else {
      const value = rem.get(key)! + 1;
      rem.set(key, value);
      return value;
    }
  }

  function travel(node: TreeNode | null) {
    if (node == null) return;

    let value = addCountKey(node.val);
    max = Math.max(value, max);
    travel(node.left);
    travel(node.right);
  }

  for (let [key, value] of rem) {
    if (value == max) {
      result.push(key);
    }
  }
  return result;
};