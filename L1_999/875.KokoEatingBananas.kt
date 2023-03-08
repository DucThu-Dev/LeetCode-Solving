fun minEatingSpeed(piles: IntArray, h: Int): Int {
    fun feasible(k: Long): Boolean {
        var rem = 0L
        for (i in piles) {
            rem += i / k
            if (i % k > 0) rem++
            if (rem > h) return false;
        }
        return true
    }

    var leftSpeed = 1L
    var rightSpeed = piles.map { it.toLong() }.sum()
    while (leftSpeed < rightSpeed) {
        val middle = leftSpeed + (rightSpeed - leftSpeed) / 2
        if (feasible(middle)) rightSpeed = middle else leftSpeed = middle + 1
    }

    return leftSpeed.toInt()
}