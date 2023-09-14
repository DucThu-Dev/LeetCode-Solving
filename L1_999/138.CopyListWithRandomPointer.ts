/// Note: Rename this class to Node when submit to the challenge.
class ListNode {
  val: number
  next: ListNode | null
  random: ListNode | null
  constructor(val?: number, next?: ListNode, random?: ListNode) {
    this.val = (val === undefined ? 0 : val)
    this.next = (next === undefined ? null : next)
    this.random = (random === undefined ? null : random)
  }
}


function copyRandomList(head: ListNode | null): ListNode | null {
  let originalMap = new Map<ListNode, number>();
  let cloneMap = new Map<number, ListNode>();
  let headLength = -1;
  let currentNode = head;

  while (currentNode !== null) {
    headLength++;
    originalMap.set(currentNode, headLength);
    const cloneNode = new ListNode(currentNode.val);
    cloneMap.set(headLength, cloneNode);
    if (headLength > 0) {
      cloneMap.get(headLength - 1)!.next = cloneNode;
    }
    currentNode = currentNode.next;
  }

  currentNode = head;
  headLength = -1;
  while (currentNode !== null) {
    headLength++;
    if (currentNode.random !== null) {
      const randomNodeIndex = originalMap.get(currentNode.random!)!;
      cloneMap.get(headLength)!.random = cloneMap.get(randomNodeIndex)!;
    }
    currentNode = currentNode.next;
  }

  return cloneMap.get(0)!;
};

function copyRandomListCloned(head: ListNode | null): ListNode | null {
  if (!head) return null;
  const map = new Map<ListNode, ListNode>();
  let currentNode: ListNode | null = head;
  let remNode: ListNode | null = null;
  while (currentNode) {
    let clonedNode = new ListNode(currentNode.val);
    map.set(currentNode, clonedNode);
    if (remNode) remNode.next = clonedNode;
    remNode = clonedNode;
    currentNode = currentNode.next;
  }

  currentNode = head;
  remNode = null;
  while (currentNode) {
    if (currentNode.random) {
      map.get(currentNode)!.random = map.get(currentNode.random!)!;
    }
    currentNode = currentNode.next;
  }

  return map.get(head)!;
};