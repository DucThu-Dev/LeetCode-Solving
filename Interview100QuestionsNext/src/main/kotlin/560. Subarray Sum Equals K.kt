package interview100questions

class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        if (nums.isEmpty()) return 0
        var count = if (nums[0] == k) 1 else 0
        if (nums.size == 1) return count

        val sumArray = IntArray(nums.size)
        sumArray[0] = nums[0]
        for (i in 1 until nums.size) {
            val current = nums[i]
            val target = k - current

            if (current == k) count++

            for (i in 0 until i) {
                if (sumArray[i] == target) count++
            }

            for (i in 0..i) {
                sumArray[i] += current
            }
        }

        return count
    }
}

class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        if (nums.size == 1) return if (nums.first() == k) 1 else 0
        var prefixSum = 0
        var count = 0
        val sumMap = HashMap<Int, Int>()
        sumMap[0] = 1
        for (i in 0 until nums.size) {
            prefixSum += nums[i]
            count += sumMap.getOrDefault(prefixSum - k, 0)
            sumMap[prefixSum] = sumMap.getOrDefault(prefixSum, 0) + 1
        }
        return count
    }
}