fun sortArray(nums: IntArray): IntArray {
    if (nums.size <= 1) return nums
    val pivot = nums.size / 2
    val leftArray = sortArray(nums.slice(0 until pivot).toIntArray())
    val rightArray = sortArray(nums.slice(pivot until nums.size).toIntArray())

    return mergeSortArray(leftArray, rightArray)
}

fun mergeSortArray(leftArray: IntArray, rightArray: IntArray): IntArray {
    val resultArray = mutableListOf<Int>()
    var leftIndex = 0
    var rightIndex = 0

    while (leftIndex < leftArray.size && rightIndex < rightArray.size) {
        if (leftArray[leftIndex] < rightArray[rightIndex]) {
            resultArray.add(leftArray[leftIndex])
            leftIndex++
        } else {
            resultArray.add(rightArray[rightIndex])
            rightIndex++
        }
    }

    while (leftIndex < leftArray.size) {
        resultArray.add(leftArray[leftIndex])
        leftIndex++
    }

    while (rightIndex < rightArray.size) {
        resultArray.add(rightArray[rightIndex])
        rightIndex++
    }

    return resultArray.toIntArray()
}

/**
 * Quick sort
 */
fun quickSortArray(nums: IntArray): IntArray {
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
        *quickSortArray(nums.subList(0, pivotIndex).toIntArray()),
        pivotValue,
        * quickSortArray(nums.subList(pivotIndex + 1, nums.size).toIntArray())
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

    return intArrayOf(*sortArrayOriginal(leftNums.toIntArray()), pivotValue, *sortArrayOriginal(rightNums.toIntArray()))
}