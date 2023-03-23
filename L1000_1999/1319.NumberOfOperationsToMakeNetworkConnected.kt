fun makeConnected(n: Int, connections: Array<IntArray>): Int {
    val map: MutableMap<Int, MutableList<Int>> = mutableMapOf()

    for (i in 0 until n) {
        map[i] = mutableListOf()
    }

    for (c in connections) {
        map[c[0]]!!.add(c[1])
        map[c[1]]!!.add(c[0])
    }

    var availableCableCount = 0
    for (entry in map) {
        availableCableCount += entry.value.fold(0) { acc, i ->
            if (i < entry.key) acc
            else acc + 1
        }
    }

    if (availableCableCount < n - 1) return -1

    var neededTimes = 0
    val notPassedComputers = MutableList(n) { it }

    fun traversal(node: Int) {
        if (notPassedComputers.contains(node)) {
            notPassedComputers.remove(node)
            for (c in map[node]!!) {
                traversal(c)
            }
        }
    }

    while (notPassedComputers.isNotEmpty()) {
        val node = notPassedComputers.first()
        neededTimes++
        traversal(node)
    }

    return neededTimes - 1
}

fun main() {
    makeConnected(6, arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(0, 3), intArrayOf(1, 2), intArrayOf(1, 3)))
}