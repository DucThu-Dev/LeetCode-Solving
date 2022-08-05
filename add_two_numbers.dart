/// https://leetcode.com/problems/add-two-numbers/
/// You are given two non-empty linked lists representing two non-negative
/// integers. The digits are stored in reverse order, and each of their nodes
/// contains a single digit. Add the two numbers and return the sum as a linked
/// list.
///
/// You may assume the two numbers do not contain any leading zero, except the
/// number 0 itself.

//  * Definition for singly-linked list.
class ListNode {
  int val;
  ListNode? next;
  ListNode([this.val = 0, this.next]);
}

class Solution {
  ListNode? addTwoNumbers(ListNode? l1, ListNode? l2) {
    return _addTwoNumbersRecursive(l1, l2, false);
  }

  ListNode? _addTwoNumbersRecursive(
      ListNode? l1, ListNode? l2, bool lastPairGreater10) {
    final firstNodeVal = l1?.val ?? 0;
    final secondNodeVal = l2?.val ?? 0;

    final sum = firstNodeVal + secondNodeVal + (lastPairGreater10 ? 1 : 0);
    final val = sum % 10;

    final result = ListNode(val);

    if (l1?.next != null || l2?.next != null || sum >= 10) {
      result.next = _addTwoNumbersRecursive(l1?.next, l2?.next, sum >= 10);
    }

    return result;
  }
}
