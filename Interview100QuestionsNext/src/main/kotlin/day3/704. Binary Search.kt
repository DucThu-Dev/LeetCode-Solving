class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        var mid = (right - left) / 2 + left
        while(left < right) {
            if(nums[mid] > target) {
                right = mid - 1
            } else if(nums[mid] < target) {
                left = mid + 1
            } else {
                break
            }
            mid = (right - left) / 2 + left
        }

        return if(nums[mid] == target) mid else -1
    }
}