fun sortArray(nums: IntArray): IntArray {
    if (nums.isEmpty() || nums.size == 1) return nums
    val nums = nums.toMutableList()
    var currentIndex = 0
    var pivotIndex = nums.size / 2
    val pivotValue = nums[pivotIndex]
    while (currentIndex < nums.size) {
        if (currentIndex < pivotIndex && nums[currentIndex] >= pivotValue) {
            nums.add(pivotIndex, nums.removeAt(currentIndex))
            pivotIndex--
        } else if (currentIndex > pivotIndex && nums[currentIndex] < pivotValue) {
            nums.add(pivotIndex, nums.removeAt(currentIndex))
            pivotIndex++
        } else {
            currentIndex++
        }
    }

    return intArrayOf(
        *sortArray(nums.subList(0, pivotIndex).toIntArray()),
        pivotValue,
        * sortArray(nums.subList(pivotIndex + 1, nums.size).toIntArray())
    )
}

fun sortArrayOriginal(nums: IntArray): IntArray {
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