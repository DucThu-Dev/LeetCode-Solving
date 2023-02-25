fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list2 == null) return list1
    if (list1 == null) return list2
    return if (list1.`val` > list2.`val`) {
        mergeTwoListWithMoreDetail(list2, list1)
    } else {
        mergeTwoListWithMoreDetail(list1, list2)
    }
}

fun mergeTwoListWithMoreDetail(smallerList: ListNode?, greaterList: ListNode?): ListNode? {
    if (greaterList == null) return smallerList
    if (smallerList == null) return greaterList

    if (smallerList.next != null && smallerList.next!!.`val` < greaterList.`val`) {
        mergeTwoListWithMoreDetail(smallerList.next, greaterList)
        return smallerList
    } else {
        var nextNode: ListNode? = mergeTwoLists(smallerList.next, greaterList.next)

        greaterList.next = nextNode
        return smallerList.apply { next = greaterList }
    }
}