import kotlin.math.max

fun countSubarrays(nums: IntArray, minK: Int, maxK: Int): Long {
    var count = 0L
    var index = 0

    var hasMin: Boolean = false
    var hasMax: Boolean = false
    var didRequestCheckSubArray = false

    while (index < nums.size) {
        val currentNum = nums[index]
        if (currentNum > maxK || currentNum < minK) {
            hasMin = false
            hasMax = false
        } else {
            if (currentNum == minK) {
                hasMin = true
                if (!didRequestCheckSubArray) {
                    count += countSubarrays(nums.copyOfRange(index + 1, nums.size), minK, maxK)
                    didRequestCheckSubArray = true
                } else if (currentNum == maxK) {
                    hasMax = true
                    if (!didRequestCheckSubArray) {
                        count += countSubarrays(nums.copyOfRange(index + 1, nums.size), minK, maxK)
                        didRequestCheckSubArray = true
                    }
                }
            }
            if (hasMin && hasMax) count++
            index++
        }
    }

    return count
}

fun main() {
    val result = countSubarrays(intArrayOf(1, 1, 1, 1), 1, 1)
    println(result)
}