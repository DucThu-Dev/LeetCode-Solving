fun countSubarrays(nums: IntArray, minK: Int, maxK: Int): Long {
    var count = 0L
    var start = 0
    var iLastMin: Int = -1
    var iLastMax: Int = -1

    for (i in 0..nums.lastIndex) {
        val currentNum = nums[i]
        if (currentNum > maxK || currentNum < minK) {
            start = i + 1
            iLastMin = -1
            iLastMax = -1
        } else {
            if (currentNum == maxK) iLastMax = i
            if (currentNum == minK) iLastMin = i

            if (iLastMin >= 0 && iLastMax >= 0) {
                val left = start
                val right = Math.min(iLastMin, iLastMax)
                count += right - left + 1
            }
        }
    }
    return count
}

fun main() {
    val result = countSubarrays(intArrayOf(1, 1, 1, 1), 1, 1)
    println(result)
}