fun sortedListToBST(head: ListNode?): TreeNode? {
    head ?: return null
    head.next ?: return TreeNode(head.`val`)
    var fast = head
    var slow = head
    var pre: ListNode? = null
    while (fast != null && fast.next != null) {
        pre = slow
        slow = slow?.next
        fast = fast?.next?.next
    }

    pre?.next = null
    return TreeNode(slow?.`val` ?: -1).apply {
        left = sortedListToBST(head)
        right = sortedListToBST(slow?.next)
    }
}

fun sortedListToBSTPractice(head: ListNode?): TreeNode? {
    head ?: return null
    head.next ?: return TreeNode(head.`val`)

    var fast = head
    var slow = head
    var pre: ListNode? = null
    while (fast?.next != null) {
        pre = slow
        slow = slow?.next
        fast = fast.next?.next
    }

    pre?.next = null

    return TreeNode(slow?.`val`!!).apply {
        left = sortedListToBSTPractice(head)
        right = sortedListToBSTPractice(slow.next)
    }
}