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

fun numRescueBoatsHighest(people: IntArray, limit: Int): Int {
    people.sort()
    var count = 0
    var i = 0
    var j = people.lastIndex
    while (i <= j) {
        if (people[i] + people[j] > limit) {
            j--
        } else {
            i++
            j--
        }
        count++
    }
    return count
}