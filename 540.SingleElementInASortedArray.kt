fun singleNonDuplicate(nums: IntArray): Int {
    var start = 0
    var end = nums.lastIndex

    while (start != end) {
        val middle = (end - start) / 2
        val checkLeftSide = middle % 2 == 1
        val middleNum = nums[middle]

        if (checkLeftSide) {
            if (middleNum == nums[middle - 1]) {
                start = middle + 1
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

fun singleNonDuplicate1(nums: IntArray): Int {
    if(nums.size == 1) return nums.first()
    if(nums.first() != nums[1]) return nums.first()
    var i = 1
    while (i < nums.lastIndex) {
        if (nums[i] == nums[i - 1] || nums[i] == nums[i + 1]) {
            i++
        } else {
            return nums[i]
        }
    }
    return nums[i]
}