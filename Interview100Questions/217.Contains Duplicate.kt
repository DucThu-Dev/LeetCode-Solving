package interview100questions

class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val set = nums.toSet()
        return nums.size != set.size
    }
}

class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val set = HashSet<Int>()
        for(i in nums.indices) {
            if(!set.add(nums[i])) return true
        }
        return false
    }
}