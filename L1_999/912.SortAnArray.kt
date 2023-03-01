fun sortArray(nums: IntArray): IntArray {
    if (nums.isEmpty() || nums.size == 1) return nums
    val nums = nums.toMutableList()

    val pivotIndex = nums.size / 2
    var pivotPair = Pair(pivotIndex, nums[pivotIndex])

    for (i in 0..nums.lastIndex) {
        if (i < pivotPair.first && nums[i] >= pivotPair.second) {
            val value = nums.removeAt(i)
            nums.add(pivotPair.first, value)
            pivotPair = (pivotPair.first - 1) to pivotPair.second
        } else if (i > pivotPair.first && nums[i] < pivotPair.second) {
            val value = nums.removeAt(i)
            nums.add(pivotPair.first, value)
            pivotPair = (pivotPair.first + 1) to pivotPair.second
        }

    }

    val result1 = sortArray(nums.subList(0, pivotPair.first).toIntArray())
    val result2 = sortArray(nums.subList(pivotPair.first + 1, nums.size).toIntArray())

    return intArrayOf(*result1, pivotPair.second, *result2).also {
        println("Current nums: $nums")
    }
}

fun main() {
//    sortArray(intArrayOf(5, 1, 1, 2, 0, 0))
    val nums = mutableListOf(5, 1, 2)
    nums.remove(1)
    nums.add(2, 5)
    println(nums)
}