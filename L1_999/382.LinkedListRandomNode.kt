class LinkedListRandomNode(val head: ListNode?) {
    fun getRandom(): Int {
        var scope = 1
        var chosenValue = 0
        var curr = this.head
        while (curr != null) {
            if (Math.random() < 1.0 / scope) {
                chosenValue = curr.`val`
            }
            scope++
            curr = curr.next
        }
        return chosenValue
    }
}
