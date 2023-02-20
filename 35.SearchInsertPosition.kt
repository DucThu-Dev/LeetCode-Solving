fun searchInsert(nums: IntArray, target: Int): Int {
    var i = 0
    while (i <= nums.lastIndex && nums[i] < target) {
        i++
    }

    return i
}