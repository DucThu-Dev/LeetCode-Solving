fun singleNonDuplicate(nums: IntArray): Int {
    var start = 0
    var end = nums.lastIndex

    while (start != end) {
        val middle = (end - start) / 2
        val checkLeftSide = middle % 2 == 1
        val middleNum = nums[middle]

        if (checkLeftSide) {
            if (middleNum == nums[middle - 1]) {
                start = middleNum + 1
            } else if (middleNum == nums[middle + 1]) {
                end = middle - 1
            } else {
                return middleNum
            }
        } else {
            if (middleNum == nums[middle + 1]) {
                start = middle + 2
            } else if (middleNum == nums[middle - 1]) {
                end = middle - 2
            } else {
                return middleNum
            }
        }
    }

    return start
}