// Definition for singly-linked list.
class ListNode {
  val: number
  next: ListNode | null
  constructor(val?: number, next?: ListNode | null) {
    this.val = (val === undefined ? 0 : val)
    this.next = (next === undefined ? null : next)
  }
}


function splitListToParts(head: ListNode | null, k: number): Array<ListNode | null> {
  if (head === null) return new Array(k).fill(null);
  const result = new Array<ListNode | null>();

  let node = head;
  let length = 1;
  while (node?.next != null) {
    length++;
    node = node.next;
  }

  const min = (length / k) >> 0;
  const remain = length % k;

  let currentNode: ListNode | null = head;

  for (let i = 0; i < k; i++) {
    let nodeCount = min;
    if (i < remain) nodeCount++;
    if (nodeCount === 0) result.push(null);
    for (let y = 0; y < nodeCount; y++) {
      if (y === 0) {
        result.push(currentNode);
      }

      if (y === nodeCount - 1) {
        let temp = currentNode?.next;
        if (currentNode != null) {
          currentNode!.next = null;
          currentNode = temp;
        }
      } else {
        currentNode = currentNode?.next ?? null;
      }
    }
  }

  return result;
};

/// CLONED FROM EFFECTIVE SPEED
function splitListToPartsClonedSpeed(head: ListNode | null, k: number): Array<ListNode | null> {
  if (head === null) return new Array(k).fill(null);
  const result = new Array<ListNode | null>(k).fill(null);

  let node = head;
  let length = 1;
  while (node?.next != null) {
    length++;
    node = node.next;
  }

  const min = (length / k) >> 0;
  const remain = length % k;

  let currentNode: ListNode | null = head;

  for (let i = 0; i < k; i++) {
    result[i] = currentNode;
    let nodeCount = min + +(i < remain);

    for (let y = 0; y < nodeCount - 1; y++) {
      currentNode = currentNode?.next ?? null;
    }

    let tail = currentNode;
    currentNode = currentNode?.next ?? null;
    if (tail != null) tail!.next = null;
  }

  return result;
};