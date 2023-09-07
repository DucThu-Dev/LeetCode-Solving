/**
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */

class ListNode {
  val: number
  next: ListNode | null
  constructor(val?: number, next?: ListNode | null) {
    this.val = (val === undefined ? 0 : val)
    this.next = (next === undefined ? null : next)
  }
}

function reverseBetween(head: ListNode | null, left: number, right: number): ListNode | null {
  if (head === null) return null;
  if (head.next === null || left === right) return head;
  let currentNode: ListNode | null = head;
  let reverseStartNode: ListNode | null | undefined = null;
  let nodeBeforeStartNode: ListNode | null = null;
  let prevNode: ListNode | null = null;
  let nodeOrder = 1;
  while (currentNode !== null) {
    if (nodeOrder === left) {
      reverseStartNode = currentNode;
      nodeBeforeStartNode = prevNode;
      prevNode = currentNode;
      currentNode = currentNode.next;
    } else if (nodeOrder > left && nodeOrder < right) {

      let originalNextNode: ListNode | null = currentNode.next;
      currentNode.next = prevNode;
      prevNode = currentNode;
      currentNode = originalNextNode;


    } else if (nodeOrder === right) {

      reverseStartNode!.next = currentNode.next;
      currentNode.next = prevNode;
      if (nodeBeforeStartNode !== null) {
        nodeBeforeStartNode!.next = currentNode;
        return head;
      }
      // assert left === 1
      return currentNode;
    } else {
      prevNode = currentNode;
      currentNode = currentNode.next;
    }
    nodeOrder++;
  }
  // Never reach;
  return head;
};