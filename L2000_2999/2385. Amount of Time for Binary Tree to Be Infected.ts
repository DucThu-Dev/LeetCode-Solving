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

type TreeNodeInfo = {
  parent: TreeNode | null,
  infected: boolean,
}

function amountOfTime(root: TreeNode | null, start: number): number {
  if (!root) return 0;
  const tree = new Map<TreeNode, TreeNodeInfo>([[root, {
    parent: null,
    infected: false,
  }]])
  let startNode: TreeNode

  updateTreeMap(root)

  function updateTreeMap(node: TreeNode | null) {
    if (!node) return;
    if (node.val === start) {
      startNode = node;
      tree.get(node)!.infected = true;
    }

    if (node?.left) {
      tree.set(node.left, {
        parent: node,
        infected: false,
      })
      updateTreeMap(node.left)
    }

    if (node?.right) {
      tree.set(node.right, {
        parent: node,
        infected: false,
      })
      updateTreeMap(node.right)
    }
  }

  let canInfectOthers: TreeNode[] = [
    startNode!,
  ]
  let time = 0;

  while (canInfectOthers.length) {
    let didInfect = false;
    let lastCanInfectOthers = canInfectOthers
    canInfectOthers = []
    for (let node of lastCanInfectOthers) {
      let infectedNodes = getInfectedFromNode(node);
      if (infectedNodes.length) {
        didInfect = true
        canInfectOthers.push(...infectedNodes)
      }
    }
    if (didInfect) time++
  }

  function getInfectedFromNode(node: TreeNode): Array<TreeNode> {
    const result: TreeNode[] = []
    let nodes: Array<TreeNode | null> = [node.left, node.right, tree.get(node)!.parent]
    for (let n of nodes) {
      if (n) {
        let info = tree.get(n)!
        if (!info.infected) {
          info.infected = true;
          result.push(n)
        }
      }
    }

    return result;
  }

  return time;
};