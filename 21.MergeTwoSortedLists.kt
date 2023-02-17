fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list2 == null) return list1
    if (list1 == null) return list2
    val trailNode = mergeTwoLists(list1.next, list2.next)
    return if (list1.`val` < list2.`val`) {
        list1.next = list2.also { it.next = trailNode }
        list1
    } else {
        list2.next = list1.also { it.next = trailNode }
        list2
    }
}