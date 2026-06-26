class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums.first()
        if (nums.size == 2) return nums.first().coerceAtLeast(nums[1])

        val dp = IntArray(nums.size) { 0 }
        dp[0] = nums.first()
        dp[1] = nums.first().coerceAtLeast(nums[1])

        for (i in 2..<nums.size) {
            dp[i] = dp[i - 1].coerceAtLeast(dp[i - 2] + nums[i])
        }

        return dp.last()
    }
}