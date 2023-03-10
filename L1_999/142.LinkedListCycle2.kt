fun detectCycle(head: ListNode?): ListNode? {
    val traversedNodes: MutableSet<ListNode> = mutableSetOf()
    return traverseLinkedList(head, traversedNodes)
}

fun traverseLinkedList(node: ListNode?, traversedNodes: MutableSet<ListNode>): ListNode? {
    if (node != null) {
        if (!traversedNodes.add(node)) return node

        node.next?.let {
            return traverseLinkedList(node.next, traversedNodes)
        }
    }

    return null
}

/// Fast and Slow pointers.
fun detectCycleFastAndSlowPointers(head: ListNode?): ListNode? {
    var slow = head
    var fast = head
    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
        if (slow === fast) {
            slow = head
            while (slow !== fast) {
                slow = slow?.next
                fast = fast?.next
            }
            return slow
        }
    }

    return null
}