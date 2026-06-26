package interview100questions

class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        if(nums.isEmpty()) return 0
        nums.sort()
        var max = 1
        var current = nums[0]
        var count = 1
        for(i in 1 until nums.size) {
            val value = nums[i]
            if(value == current) continue
            if(value != current + 1) {
                current  = value
                max = max.coerceAtLeast(count)
                count = 1
                continue
            }
            count++
            current = value
        }

        return max.coerceAtLeast(count)
    }
}