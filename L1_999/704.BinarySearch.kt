fun search(nums: IntArray, target: Int): Int {
    var start = 0
    var end = nums.lastIndex

    while (start < end) {
        val middle = start + (end - start) / 2
        if (nums[middle] == target) {
            return middle
        } else if (nums[middle] < target) {
            start = middle + 1
        } else {
            end = middle
        }
    }

    return if (nums[start] == target) start else -1
}