class ListNode {
  val: number
  next: ListNode | null
  constructor(val?: number, next?: ListNode | null) {
    this.val = (val === undefined ? 0 : val)
    this.next = (next === undefined ? null : next)
  }
}

function removeNodes(head: ListNode | null): ListNode | null {
  if (!head) return head;
  let current: ListNode | null = head;
  let next = current.next;
  head.next = null;
  while (current && next) {
    let temp = next.next;
    next.next = current;
    current = next;
    next = temp;
  }

  // Now current is head
  head = current
  while (current.next) {
    if (current.next.val >= current.val) {
      current = current?.next;
    } else {
      current.next = current.next.next;
    }
  }

  // Now current is tail, update it
  current = head!;
  next = current.next;
  current.next = null
  while (current && next) {
    let temp = next.next;
    next.next = current
    current = next;
    next = temp;
  }
  return current;
};

function removeNodes0(head: ListNode | null): ListNode | null {
  const nodes: ListNode[] = []
  const result: ListNode[] = []
  while (head) {
    nodes.push(head);
    head = head.next;
  }
  result.push(nodes.pop()!);
  for (let i = nodes.length - 1; i >= 0; i--) {
    if (nodes[i].val >= result[0].val) {
      result.unshift(nodes[i]);
    }
  }
  head = result.shift()!;
  let current = head;
  for (let i = 0; i < result.length; i++) {
    current.next = result[i];
    current = current.next;
  }
  return head;
};