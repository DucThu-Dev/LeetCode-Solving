import java.util.PriorityQueue

fun minimumDeviation(nums: IntArray): Int {
    val priorityQueue = PriorityQueue<Int> { o1, o2 -> if ((o1 ?: 0) < (o2 ?: 0)) 1 else -1 }
    var minDiff = Int.MAX_VALUE
    var currentMinNum = Int.MAX_VALUE

    for (n in nums) {
        val accessNum = if (n % 2 == 1) n * 2 else n
        priorityQueue.add(accessNum)
        currentMinNum = currentMinNum.coerceAtMost(accessNum)
    }

    while (minDiff > 0) {
        val max = priorityQueue.poll()

        minDiff = if (max - currentMinNum < minDiff) max - currentMinNum else minDiff

        if (max % 2 == 1) break
        val dividedMax = max / 2
        currentMinNum = currentMinNum.coerceAtMost(dividedMax)
        priorityQueue.add(dividedMax)
    }
    return minDiff
}
