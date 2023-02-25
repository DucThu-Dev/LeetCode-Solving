fun removeDuplicates(nums: IntArray): Int {
    val indexUniqueNums = mutableListOf<Int>(0)
    var currentNum = nums[0]

    for (i in 1..nums.lastIndex) {
        if (currentNum != nums[i]) {
            indexUniqueNums.add(i)
            currentNum = nums[i]
        }
    }

    val result = indexUniqueNums.size

    for ((currentIndex, i) in indexUniqueNums.withIndex()) {
        nums[currentIndex] = nums[i]
    }

    return result
}