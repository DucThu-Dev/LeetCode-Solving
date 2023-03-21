val zeroFilledSubArrayGraph = mutableMapOf<Long, Long>(0L to 0L, 1L to 1L)

fun calculateSubArrayWithZeroContiguous(n: Long): Long {
    if (n == 1L) return 1L
    var result = zeroFilledSubArrayGraph[n]
    if (result == null) {
        result = (calculateSubArrayWithZeroContiguous(n - 1) + n).also {
            zeroFilledSubArrayGraph[n] = it
        }
    }

    return result!!
}

fun zeroFilledSubarray(nums: IntArray): Long {
    var isZero = false
    var total = 0L
    var currentCount = 0L

    for (n in nums) {
        if (n == 0) {
            currentCount++
        } else {
            total += calculateSubArrayWithZeroContiguous(currentCount)
            currentCount = 0L
        }
    }

    if (currentCount > 0L) {
        total += calculateSubArrayWithZeroContiguous(currentCount)
    }

    return total
}