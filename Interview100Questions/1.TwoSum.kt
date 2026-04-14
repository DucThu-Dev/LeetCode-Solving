package interview100questions

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        for(i in 0 .. nums.size - 2) {
        val current = nums[i]
        val remain = target - current
            for(j in i  + 1 until nums.size) {
                if(nums[j] == remain) {
                    return intArrayOf(i, j)
                }
            }
        }

        throw Exception("No result")
    }
}

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val dp = mutableMapOf<Int, Int>()
        for(i in nums.indices) {
            val remain = target - nums[i]
            if(dp.contains(remain)) return intArrayOf(i, dp[remain]!!)
            else dp[nums[i]]= i
        }

        throw Exception("Bad test case")
    }
}