fun numRescueBoats(people: IntArray, limit: Int): Int {
    var count = 0
    people.sort()
    val queue = MutableList<Int>(people.size) { people[it] }
    while (queue.isNotEmpty()) {
        val last = queue.removeLast()
        if (queue.isNotEmpty() && queue.first() + last <= limit) queue.removeFirst()
        count++
    }

    return count
}

fun main() {
    numRescueBoats(intArrayOf(3, 2, 2, 1), 3)
}

fun MutableList<Int>.removeLast(): Int {
    val last = last()
    removeAt(lastIndex)
    return last
}

fun MutableList<Int>.removeFirst(): Int {
    val first = first()
    removeAt(0)
    return first
}