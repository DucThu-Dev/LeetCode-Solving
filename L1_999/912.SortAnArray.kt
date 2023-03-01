fun sortArray(nums: IntArray): IntArray {
    if (nums.isEmpty() || nums.size == 1) return nums
    val leftNums = mutableListOf<Int>()
    val rightNums = mutableListOf<Int>()

    val pivotIndex = nums.size / 2
    val pivotValue = nums[pivotIndex]

    for (i in 0..nums.lastIndex) {
        if (i != pivotIndex) {
            if (nums[i] < pivotValue)
                leftNums.add(nums[i])
            else
                rightNums.add(nums[i])
        }
    }

    return intArrayOf(*sortArray(leftNums.toIntArray()), pivotValue, *sortArray(rightNums.toIntArray()))
}