import java.util.PriorityQueue

fun findMaximizedCapital(k: Int, w: Int, profits: IntArray, capital: IntArray): Int {
    var remainProject = k
    var totalCapital = 0
    val priorityQueue = PriorityQueue<Int>()
    for (pIndex in profits.indices) {
        if (capital[pIndex] < w) {
            priorityQueue.add(profits[pIndex] - capital[pIndex])
        }
    }

    while (remainProject > 0 || priorityQueue.isNotEmpty()) {
        totalCapital += priorityQueue.poll() ?: 0
        remainProject --
    }

    return totalCapital
}

fun main() {
    val result = findMaximizedCapital(2, 0, intArrayOf(1,2,3), intArrayOf(0,1,1))
    println(result)
}