import java.util.PriorityQueue

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    val priorityQueue = PriorityQueue<Int>()

    for (n in lists) {
        var curr = n
        while (curr != null) {
            priorityQueue.add(curr.`val`)
            curr = curr.next
        }
    }

    if (priorityQueue.isEmpty()) {
        return null
    }

    val res = ListNode(priorityQueue.poll())
    var last = res

    var curr: Int? = priorityQueue.poll()

    while (curr != null) {
        last.next = ListNode(curr)
        last = last.next!!
        curr = priorityQueue.poll()
    }

    return res
}