fun singleNonDuplicate(nums: IntArray): Int {
    if (nums.size == 1) return nums.first()
    if (nums.first() != nums[1]) return nums.first()
    if (nums.last() != nums[nums.lastIndex - 1]) return nums.last()

    var startIndex = 0
    var endIndex = nums.lastIndex

    while (startIndex < endIndex) {
        var middleIndex: Int = (endIndex - startIndex) / 2 + startIndex
        if (middleIndex % 2 == 1) middleIndex--

        if (nums[middleIndex] == nums[middleIndex + 1]) {
            startIndex = middleIndex + 2
        } else {
            endIndex = middleIndex
        }
    }
    return nums[startIndex]
}

fun singleNonDuplicate1(nums: IntArray): Int {
    if (nums.size == 1) return nums.first()
    if (nums.first() != nums[1]) return nums.first()
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