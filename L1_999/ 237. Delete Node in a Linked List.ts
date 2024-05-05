
class ListNode {
  val: number
  next: ListNode | null
  constructor(val?: number, next?: ListNode | null) {
    this.val = (val === undefined ? 0 : val)
    this.next = (next === undefined ? null : next)
  }
}

function deleteNode(node: ListNode | null): void {
  if (!node) return;
  const nextNode = node?.next!;
  node.val = nextNode!.val;
  if (nextNode.next) {
    node.next = nextNode.next;
    nextNode.next = null;
  } else {
    node.next = null;
  }
};