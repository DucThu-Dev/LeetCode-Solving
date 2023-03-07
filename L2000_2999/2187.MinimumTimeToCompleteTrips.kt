fun minimumTime(time: IntArray, totalTrips: Int): Long {
    fun feasible(t: Long): Boolean {
        var rem = 0L
        for (n in time) {
            rem += t / n
        }
        return rem >= totalTrips
    }

    var min = 1L
    var max: Long = time.max().toLong()

    var foundMax = false
    while (!foundMax) {
        if (feasible(max)) {
            foundMax = true
        } else {
            min = max
            max *= 2
        }
    }

    while (min < max) {
        val middle = min + (max - min) / 2
        if (feasible(middle)) max = middle else min = middle + 1
    }

    return min
}

fun main() {
    val result = minimumTime(intArrayOf(2), 1)
    println(result)
}