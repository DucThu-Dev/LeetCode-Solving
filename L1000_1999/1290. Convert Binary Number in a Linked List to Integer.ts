// Definition for singly-linked list.
// class ListNode {
//   val: number;
//   next: ListNode | null;
//   constructor(val?: number, next?: ListNode | null) {
//     this.val = val === undefined ? 0 : val;
//     this.next = next === undefined ? null : next;
//   }
// }

function getDecimalValue(head: ListNode | null): number {
  let binary = "";
  let currentNode = head;
  while (currentNode) {
    binary = `${binary}${currentNode.val}`;
    currentNode = currentNode.next;
  }

  return parseInt(binary, 2);
}
