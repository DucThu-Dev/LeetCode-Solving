fun minimizeArrayValue(nums: IntArray): Int {
    var answer = 0L
    var prefixSum = 0L

    for (i in nums.indices) {
        prefixSum += nums[i]
        answer = answer.coerceAtLeast((prefixSum + i) / (i + 1))
    }

    return answer.toInt()
}