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

function doubleIt(head: ListNode | null): ListNode | null {
  let current = head;
  let next = current?.next;
  current!.next = null;

  while (current && next) {
    let temp = next.next
    next.next = current
    current = next
    next = temp
  }

  // Now current is head and the original trail
  head = current
  let plusOne = false
  while (current) {
    const value = (current.val * 2 % 10) + +plusOne
    plusOne = (current.val * 2 / 10 >> 0) > 0
    current.val = value;
    current = current.next
  }

  // Reverse it
  current = head
  next = current?.next
  current!.next = null
  while (current && next) {
    let temp = next.next
    next.next = current
    current = next
    next = temp
  }

  if (plusOne) {
    return new ListNode(1, current)
  }
  return current;
};